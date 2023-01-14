package com.pattern.strategyfactrory.service;

public interface DistributionLockService {

    void tryLock(String key, String value, long seconds);

    boolean lock(String key, String value, long seconds);

    boolean unlock(String key, String value);
}
