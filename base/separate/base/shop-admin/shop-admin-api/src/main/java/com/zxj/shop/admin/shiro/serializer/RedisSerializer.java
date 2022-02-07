package com.zxj.shop.admin.shiro.serializer;


import com.zxj.shop.admin.shiro.exception.SerializationException;

public interface RedisSerializer<T> {

    byte[] serialize(T t) throws SerializationException;

    T deserialize(byte[] bytes) throws SerializationException;
}
