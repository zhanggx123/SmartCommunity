package com.tqzl.redis.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import com.tqzl.core.exception.BizException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author ZhangGuoxiang
 * @since 2024-01-24 14:56
 **/
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Component
public class RedisUtil {

    private final RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedissonClient redissonClient;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean has(String key) {
        return Convert.toBool(redisTemplate.hasKey(key));
    }

    public long getExpire(String key) {
        return Convert.toLong(redisTemplate.getExpire(key, TimeUnit.SECONDS));
    }

    public void setExpire(String key, long seconds) {
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    public void clearExpire(String key) {
        redisTemplate.boundValueOps(key).persist();
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    //************************************************** String类型 **************************************************//

    public String get(String key) {
        return Convert.toStr(redisTemplate.opsForValue().get(key));
    }

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String value, long seconds) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }

    public void set(String key, String value, long seconds, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }

    public void set(Map<String, String> keyValueMap) {
        redisTemplate.opsForValue().multiSet(keyValueMap);
    }

    //************************************************** Set类型 **************************************************//

    public Set<Object> sGet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    public void sSet(String key, Object... values) {
        redisTemplate.opsForSet().add(key, values);
    }

    public boolean sHas(String key, Object value) {
        return Convert.toBool(redisTemplate.opsForSet().isMember(key, value));
    }

    public void sRemove(String key, Object... values) {
        redisTemplate.opsForSet().remove(key, values);
    }

    //************************************************** Hash类型 **************************************************//

    public Map<String, Object> hGet(String key) {
        Map<String, Object> result = MapUtil.newHashMap();
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        if (MapUtil.isEmpty(map)) {
            return result;
        }
        map.forEach((k, v) -> result.put(Convert.toStr(k), v));
        return result;
    }

    public Object hGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    public void hSet(String key, Map<String, Object> hashMap) {
        redisTemplate.opsForHash().putAll(key, hashMap);
    }

    public boolean hHas(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    public long hRemove(String key, Object... hashKeys) {
        return redisTemplate.opsForHash().delete(key, hashKeys);
    }

    public long hSize(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    //************************************************** redis锁 **************************************************//

    public void doWithLock(String key, String msg, Runnable runnable) {
        RLock lock = redissonClient.getLock(key);
        try {
            if (!lock.tryLock()) {
                throw new BizException(msg);
            }
            runnable.run();
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public void doWithLock(String key, int second, String msg, Runnable runnable) {
        RLock lock = redissonClient.getLock(key);
        try {
            if (!lock.tryLock(second, TimeUnit.SECONDS)) {
                throw new BizException(msg);
            }
            runnable.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public <T> T callWithLock(String key, String msg, Supplier<T> supplier) {
        RLock lock = redissonClient.getLock(key);
        try {
            if (!lock.tryLock()) {
                throw new BizException(msg);
            }
            return supplier.get();
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public <T> T callWithLock(String key, int second, String msg, Supplier<T> supplier) {
        RLock lock = redissonClient.getLock(key);
        try {
            if (!lock.tryLock(second, TimeUnit.SECONDS)) {
                throw new BizException(msg);
            }
            return supplier.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }


    /**
     * 自增
     * @param key
     * @param value
     * @return
     */
    public Long increment(String key, int value) {
        return redisTemplate.opsForValue().increment(key, value);
    }

    /**
     * 向Zset里添加成员
     *
     * @param key   key值
     * @param score 分数，通常用于排序
     * @param value 值
     * @return 增加状态
     */
    public boolean zAdd(String key, long score, String value) {
        Boolean result = redisTemplate.opsForZSet().add(key, value, score);
        return result;
    }

    /**
     * 获取 某key 下 某一分值区间的队列
     *
     * @param key  缓存key
     * @param from 开始时间
     * @param to   结束时间
     * @return 数据
     */
    public Set<ZSetOperations.TypedTuple<Object>> zRangeByScore(String key, int from, long to) {
        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate.opsForZSet().rangeByScoreWithScores(key, from, to);
        return set;
    }

    /**
     * 移除 Zset队列值
     *
     * @param key   key值
     * @param value 删除的集合
     * @return 删除数量
     */
    public Long zRemove(String key, String... value) {
        return redisTemplate.opsForZSet().remove(key, value);
    }

}
