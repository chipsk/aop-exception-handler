package com.pattern.strategyfactrory.biz.listener;

import com.pattern.strategyfactrory.model.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
@Slf4j
public abstract class AbstractListener<T extends BaseEvent> implements ApplicationListener<T> {
    public AbstractListener() {

    }

    public void onApplicationEvent(T event) {
        long start = System.currentTimeMillis();
        String eventName = event.getClass().getSimpleName();
        log.info(String.format("开始处理事件, eventName: %s, eventString: %s, trackUuid: %s ", eventName, event.toString(), event.getTrackUuid()));
        try {
            process(event);
        } catch (Exception e) {
            log.error(String.format("处理事件时出现异常, eventName: %s, eventString: %s, trackUuid: %s, e: %s", eventName, event.toString(), event.getTrackUuid()), e);
        }

        log.info(String.format("处理事件完成, event: %s trackUuid: %s, 执行时长: %s", eventName, event.getTrackUuid(), System.currentTimeMillis() - start));
    }

    protected abstract void process(T event);
}
