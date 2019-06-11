package com.pinjingjing.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by james.geng
 * Date: 2018\4\27 0027
 *
 * @function redis工具类
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public RedisUtil() {
    }

    /**
     * 获取redisTemplate实例
     *
     * @return
     */
    public RedisTemplate getRedisTemplate() {
        return this.redisTemplate;
    }

    /**
     * 检测是否连接成功
     *
     * @return
     */
    public String ping() {
        return (String) redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.ping();
            }
        });
    }


    /**
     * 有无key
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return this.redisTemplate.hasKey(key);
    }


    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        set(key, value, 0l);
    }


    /**
     * 添加key value
     * 设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key, Object value, long liveTime) {
        if (liveTime > 0)
            this.redisTemplate.opsForValue().set(key, value, liveTime);
        this.redisTemplate.opsForValue().set(key, value);
    }


    /**
     * 添加key value
     * 设置存活时间（单位）
     *
     * @param key
     * @param value
     * @param liveTime
     * @param unit
     */
    public void set(String key, Object value, long liveTime, TimeUnit unit) {
        if (liveTime > 0){
        	this.redisTemplate.opsForValue().set(key, value, liveTime, unit);
        }else{
        	this.redisTemplate.opsForValue().set(key, value);
        }
    }

    
    

    /**
     * 通过正则匹配keys
     *
     * @param pattern
     */
    public Set patternKeys(String pattern) {
        Set keys = null;
        if (StringUtils.isNotEmpty(pattern)) {
            keys = this.redisTemplate.keys(pattern);
        }
        return keys;
    }

    /**
     * 获取值
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }


    /**
     * 查看redis里有多少数据
     *
     * @return
     
    public long dbSize() {
        return (long) redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.dbSize();
            }
        });
    }
    
    */


    /**
     * 删除key
     *
     * @param key
     */
    public void delKey(String key) {
        this.redisTemplate.delete(key);
    }


    /**
     * 删除key集
     *
     * @param keys
     */
    public void delKeys(Collection keys) {
        if (keys != null && keys.size() > 0) {
            this.redisTemplate.delete(keys);
        }
    }


    /**
     * 清空所有数据
     *
     * @return
     */
    public String flushDB() {
        return redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.flushDb();
                return "ok";
            }
        }).toString();
    }


    /**
     * 缓存类型
     */
    public void getOperations() {
        //String,Object
        ValueOperations value = redisTemplate.opsForValue();
        //hash集合
        HashOperations hash = redisTemplate.opsForHash();
        //list
        ListOperations list = redisTemplate.opsForList();
        //set
        SetOperations set = redisTemplate.opsForSet();
        //zset有序
        ZSetOperations zset = redisTemplate.opsForZSet();
    }

    /**
     * 解决写入redis缓存时key乱码问题
     * @param redisTemplate
     */
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    /**
     * 拼接参数作为redis key
     *
     * @return
     */
    public static String concatParam(String... strings) {
        String key = "";
        for (String str : strings) {
            if (StringUtils.isNotBlank(str))
                key += str + "_";
        }
        return key == "" ? "" : key.substring(0, key.length() - 1);
    }

}
