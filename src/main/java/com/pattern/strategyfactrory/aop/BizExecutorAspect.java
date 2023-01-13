package com.pattern.strategyfactrory.aop;


import com.pattern.strategyfactrory.error.base.ErrorException;
import com.pattern.strategyfactrory.model.req.ErrorRequest;
import com.pattern.strategyfactrory.service.ErrorService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class BizExecutorAspect {

    @Autowired
    ErrorService errorService;

    @Around("execution(* com.pattern.strategyfactrory.biz.executor..*(..))")
    public Object errorAroundAspect(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = null;
        try {
            retVal = pjp.proceed();
        } catch (Throwable e) {
            if (e instanceof ErrorException) {
                ErrorException error = (ErrorException) e;

                //构造request
                ErrorRequest request = new ErrorRequest();
                request.setErrorException(error);

                //策略+工厂处理aop异常
                errorService.handle(request);
            }
        }
        return retVal;
    }
}
