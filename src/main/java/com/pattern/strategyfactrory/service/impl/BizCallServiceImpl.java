package com.pattern.strategyfactrory.service.impl;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import com.pattern.strategyfactrory.biz.executor.Executor;
import com.pattern.strategyfactrory.constants.BizConstants;
import com.pattern.strategyfactrory.enums.BizCallStageEnum;
import com.pattern.strategyfactrory.model.req.ExecuteBizCallRequest;
import com.pattern.strategyfactrory.service.BizCallService;
import com.pattern.strategyfactrory.service.DistributionLockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BizCallServiceImpl implements BizCallService {


    @Autowired
    private Executor executor;

    @Autowired
    private DistributionLockService distributionLockService;


    @Override
    public Long ExecuteBizCall(ExecuteBizCallRequest request) {
        TaskCallContext ctx = new TaskCallContext();
        ctx.setLeadId(request.getLeadId());
        ctx.setDriverId(request.getDriverId());
        ctx.setPhone(request.getPhone());
        ctx.setStage(BizCallStageEnum.INIT);

        String lockKey = BizConstants.BIZ_CALL_LOCK_KEY + request.getSourceId() + "_" +request.getBusinessId();
        String value = request.getBusinessId();

        try {
            distributionLockService.tryLock(lockKey, value, 2);

            //execute
            executor.doCall(ctx);

            distributionLockService.unlock(lockKey, value);
        } catch (Exception e) {
            log.error("ExecuteBizCall err:{}", e.getMessage(), e);
            throw e;
        }

        return 1L;
    }
}
