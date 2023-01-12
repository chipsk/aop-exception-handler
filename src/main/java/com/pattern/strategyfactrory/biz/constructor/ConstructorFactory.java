package com.pattern.strategyfactrory.biz.constructor;


import com.pattern.strategyfactrory.biz.constructor.impl.DefaultConstructor;
import com.pattern.strategyfactrory.biz.constructor.impl.BizConstructor;
import com.pattern.strategyfactrory.constants.BizConstants;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ConstructorFactory implements InitializingBean {

    private static final Map<Integer, Constructor> CONSTRUCTOR_MAP = new ConcurrentHashMap<>(16);

    @Autowired
    private DefaultConstructor defaultConstructor;

    @Autowired
    private BizConstructor bizConstructor;


    public Constructor getInstance(Integer constructorId) {
        return CONSTRUCTOR_MAP.getOrDefault(constructorId, defaultConstructor);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        CONSTRUCTOR_MAP.put(BizConstants.BIZ_CONSTRUCTOR, bizConstructor);
        CONSTRUCTOR_MAP.put(BizConstants.DEFAULT_CONSTRUCTOR, defaultConstructor);
    }
}
