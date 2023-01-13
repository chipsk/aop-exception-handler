package com.pattern.strategyfactrory.biz.executor;

import com.pattern.strategyfactrory.biz.action.Action;
import com.pattern.strategyfactrory.biz.caller.Caller;
import com.pattern.strategyfactrory.biz.constructor.ConstructorFactory;
import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import com.pattern.strategyfactrory.biz.filter.Filter;
import com.pattern.strategyfactrory.biz.preFilter.PreFilter;
import com.pattern.strategyfactrory.enums.BizCallStageEnum;
import com.pattern.strategyfactrory.error.RetryErrors;
import com.pattern.strategyfactrory.model.BizCallTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
@Slf4j
public class Executor {

    @Autowired
    ApplicationContext context;

    @Autowired
    private ConstructorFactory constructorFactory;

    @Autowired
    private Map<String, Caller> callerMap;

    public Long doCall(TaskCallContext ctx) {

        // pre filter
        List<PreFilter> preFilterList = new ArrayList<>();
        Map<String, PreFilter> preFilterMap = context.getBeansOfType(PreFilter.class);
        for (Map.Entry<String, PreFilter> entry : preFilterMap.entrySet()) {
            preFilterList.add(entry.getValue());
        }
        AnnotationAwareOrderComparator.sort(preFilterList);
        for (PreFilter preFilter : preFilterList) {
            Boolean success = preFilter.doPreFilter(ctx);
            if (!success) {
                return 0L;
            }
        }


        // init: constructor
        if (ctx.getStage().equals(BizCallStageEnum.INIT)) {
            BizCallTask t = ctx.getTask();
            Boolean success = constructorFactory.getInstance(t.getConstructorId()).constructor(ctx);
            if (!success) {
                return 0L;
            }

            ctx.setStage(BizCallStageEnum.FILTER);
        }



        // filter: filter
        if (ctx.getStage().equals(BizCallStageEnum.FILTER)) {
            List<Filter> filterList = new ArrayList<>();
            Map<String, Filter> filterMap = context.getBeansOfType(Filter.class);
            for (Map.Entry<String, Filter> entry : filterMap.entrySet()) {
                filterList.add(entry.getValue());
            }
            AnnotationAwareOrderComparator.sort(filterList);
            for (Filter filter : filterList) {
                Boolean success = filter.doFilter(ctx);
                if (!success) {
                    throw RetryErrors.INSTANCE.bizCallFilter().exception();
                }
            }

            // set next stage
            ctx.setStage(BizCallStageEnum.EXECUTE);
        }

        // execute: executor
        if (ctx.getStage().equals(BizCallStageEnum.EXECUTE)) {
            // do call
            callerMap.get(ctx.getCallerName()).doCall(ctx);

            ctx.setStage(BizCallStageEnum.POST_ACTION);
        }

        if (ctx.getStage().equals(BizCallStageEnum.POST_ACTION)) {

            List<Action> actions = new ArrayList<>();
            Map<String, Action> actionMap = context.getBeansOfType(Action.class);
            for (Map.Entry<String, Action> entry : actionMap.entrySet()) {
                actions.add(entry.getValue());
            }
            AnnotationAwareOrderComparator.sort(actions);
            for (Action action : actions) {
                action.doAction(ctx);
            }
        }

        return 1L;
    }
}
