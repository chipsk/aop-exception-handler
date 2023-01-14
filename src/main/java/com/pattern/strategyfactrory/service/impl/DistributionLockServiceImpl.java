package com.pattern.strategyfactrory.service.impl;

import com.pattern.strategyfactrory.service.DistributionLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DistributionLockServiceImpl implements DistributionLockService {

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    private static final String NX = "NX";
    private static final String EX = "EX";
    private static final String OK = "OK";

    private static final String UNLOCK_LUA;

    static {
        UNLOCK_LUA = "if redis.call(\"get\", KEYS[1]) == ARGV[1] " +
                "then " +
                "    return redis.call(\"del\", KEYS[1]) " +
                "else " +
                "    return 0 " +
                "end ";
    }

    @Override
    public void tryLock(String key, String value, long seconds) {
        while (!lock(key, value, seconds)) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // ignore
            }
        }
    }

    @Override
    public boolean lock(String key, String value, long seconds) {
        return OK.equalsIgnoreCase(setNxEx(key, value, seconds));
    }

    private String setNxEx(String key, String value, long seconds) {
        return stringRedisTemplate.execute((RedisCallback<String>) connection -> {
            Object nativeConnection = connection.getNativeConnection();
            if (nativeConnection instanceof JedisCommands) {
                return ((JedisCommands) nativeConnection).set(key, value, NX, EX, seconds);
            } else {
                return null;
            }
        });
    }

    @Override
    public boolean unlock(String key, String value) {
        Long ret = stringRedisTemplate.execute((RedisConnection connection) -> {
            Object nativeConnection = connection.getNativeConnection();

            List<String> keys = new ArrayList<>();
            keys.add(key);
            List<String> values = new ArrayList<>();
            values.add(value);

            return (Long) ((Jedis) nativeConnection).eval(UNLOCK_LUA, keys, values);

        });
        return Objects.equals(ret, 1L);
    }

}
