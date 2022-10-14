package com.pattern.strategyfactrory.strategy;

import com.pattern.strategyfactrory.error.base.ErrorTag;
import com.pattern.strategyfactrory.utils.ClassScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

@Component
@SuppressWarnings("unchecked")
public class HandlerProcessor implements BeanFactoryPostProcessor {

    //这里是具体的handler策略类的包位置， 为了后面的包扫描
    private static final String HANDLE_PACKAGE = "com.pattern.strategyfactrory.strategy.handler";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> handlerMap = new HashMap<>();
        //包扫描
        ClassScanner.scan(HANDLE_PACKAGE, HandlerType.class).forEach(clazz -> {
            Annotation annotation = clazz.getAnnotation(HandlerType.class);
            HandlerType handlerType = (HandlerType) annotation;
            ErrorTag errorTag = handlerType.value();
            handlerMap.put(errorTag.getTagName(), clazz);
        });
        HandlerContext handlerContext = new HandlerContext(handlerMap);
        //注册单例
        beanFactory.registerSingleton(HandlerContext.class.getName(), handlerContext);
    }
}
