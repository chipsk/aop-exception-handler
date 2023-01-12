package com.pattern.strategyfactrory.biz.context;

import com.pattern.strategyfactrory.model.BizCallTask;
import lombok.Data;

@Data
public class TaskCallContext extends CallContext{

    private BizCallTask task;

}
