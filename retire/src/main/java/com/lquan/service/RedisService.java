package com.lquan.service;

public interface RedisService {

    void set(String key, Object value);

    void set(String key, String value);

    void set(String key, Object value, long expireTime);

    void set(String key, String value, long expireTime);

    void hashSet(String key, Object hk, Object value);

    boolean exists(final String key);

    <T> T get(String key, Class<T> clazz);

    <T> T hashGet(String key, Object hk, Class<T> clazz);

    String get(String key);

    String hashGet(String key, Object hk);

    boolean delete(String key);

    long hashDelete(String key, Object hk);

    int getExpire();

}
