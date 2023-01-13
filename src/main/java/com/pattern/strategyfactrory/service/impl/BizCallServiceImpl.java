package com.pattern.strategyfactrory.service.impl;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import com.pattern.strategyfactrory.biz.executor.Executor;
import com.pattern.strategyfactrory.enums.BizCallStageEnum;
import com.pattern.strategyfactrory.model.req.ExecuteBizCallRequest;
import com.pattern.strategyfactrory.service.BizCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BizCallServiceImpl implements BizCallService {


    @Autowired
    private Executor executor;


    @Override
    public Long ExecuteBizCall(ExecuteBizCallRequest request) {
        TaskCallContext ctx = new TaskCallContext();
        ctx.setLeadId(request.getLeadId());
        ctx.setDriverId(request.getDriverId());
        ctx.setPhone(request.getPhone());
        ctx.setStage(BizCallStageEnum.INIT);

        //execute
        executor.doCall(ctx);

        return 1L;
    }
}
