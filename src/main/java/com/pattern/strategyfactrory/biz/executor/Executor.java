package com.pattern.strategyfactrory.biz.executor;

import com.pattern.strategyfactrory.biz.constructor.ConstructorFactory;
import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import com.pattern.strategyfactrory.model.BizCallTask;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Executor {

    @Autowired
    ApplicationContext context;

    @Autowired
    private ConstructorFactory constructorFactory;

    public Long doCall(TaskCallContext ctx) {

        // pre filter



        // constructor
        BizCallTask t = ctx.getTask();
        boolean success = constructorFactory.getInstance(t.getConstructorId()).constructor(ctx);
        if (!success) {
            return 0L;
        }

        return 1L;
    }
}
