package com.pattern.strategyfactrory.biz.constructor.impl;

import com.pattern.strategyfactrory.model.BizCallTask;
import com.pattern.strategyfactrory.biz.constructor.Constructor;
import com.pattern.strategyfactrory.biz.context.TaskCallContext;

public abstract class AbstractConstructor implements Constructor {


    // 可以设置自己相应的模版方法
    protected abstract boolean commonMethod(TaskCallContext ctx);



    // 模版方法实现


    @Override
    public Boolean constructor(TaskCallContext ctx) {

        // build context

        BizCallTask task = ctx.getTask();

        // build task and so on ...

        return true;
    }
}
