package com.amei.knowledge.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class redisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 给一个指定的 key 值附加过期时间（秒）
     *
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 根据key获取过期时间
     *
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 检测key是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 移除指定key的过期时间，持久化操作
     *
     * @param key
     * @return
     */
    public boolean persist(String key) {
        return redisTemplate.boundValueOps(key).persist();
    }


    /**
     * 删除key
     *
     * @param key
     * @return
     */
    public boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 删除keys
     *
     * @param keys
     * @return
     */
    public boolean deleteKeys(Collection<String> keys) {
        return redisTemplate.delete(keys) == keys.size();
    }

    /**
     * 删除相似key
     *
     * @param key
     * @return
     */
    public boolean deleteKeyLike(String key) {
        if (key == null || key.trim().equals("")) {
            return false;
        }
        Set<String> keys = redisTemplate.keys(key + "*");
        if (keys.isEmpty()) {
            return false;
        }
        return deleteKeys(keys);
    }

    //- - - - - - - - - - - - - - - - - - - - -  String类型操作 - - - - - - - - - - - - - - - - - - - -

    /**
     * 根据key获取值
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 将字符串放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 将值放入缓存并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) -1为无期限
     * @return
     */
    public void set(String key, String value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * 批量添加 key (重复的键会覆盖)
     *
     * @param keyAndValue
     */
    public void batchSet(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSet(keyAndValue);
    }

    /**
     * 批量添加 key-value 只有在键不存在时,才添加
     * map 中只要有一个key存在,则全部不添加
     *
     * @param keyAndValue
     */
    public void batchSetIfAbsent(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSetIfAbsent(keyAndValue);
    }

    /**
     * 对一个 key-value 的值进行加减操作
     * 如果该 key 不存在 将创建一个key 并赋值该 number
     * 如果 key 存在,但 value 不是长整型将报错
     *
     * @param key
     * @param number
     */
    public Long increment(String key, long number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    //- - - - - - - - - - - - - - - - - - - - -  hash类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * Hash类型加入Map
     *
     * @param key
     * @param map
     * @param time 过期时间（秒）
     */
    public void hashPutMap(String key, Map<Object, Object> map, long time) {
        redisTemplate.opsForHash().putAll(key, map);
        if (time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    /**
     * Hash类型加入hk
     *
     * @param key
     * @param hk
     * @param hv
     */
    public void hashPutKey(String key, String hk, Object hv) {
        redisTemplate.opsForHash().put(key, hk, hv);
    }

    /**
     * 获取指定key的所有hashkey和value
     *
     * @param key 键
     * @return
     */
    public Map<Object, Object> hashGetByKey(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取指定key的值
     *
     * @param key
     * @param hk
     * @return
     */
    public Object hashGetByHk(String key, String hk) {
        return redisTemplate.opsForHash().get(key, hk);
    }

    /**
     * 批量获取hk的值
     *
     * @param key
     * @param hks
     * @return
     */
    public List<Object> hashMulitGetByHk(String key, List hks) {
        return redisTemplate.opsForHash().multiGet(key, hks);
    }

    /**
     * 验证指定ke下有没有指定的hk
     *
     * @param key
     * @param hk
     * @return
     */
    public boolean hashHasHk(String key, String hk) {
        return redisTemplate.opsForHash().hasKey(key, hk);
    }

    /**
     * 删除指定 hash 的 HashKey
     *
     * @param key
     * @param hashKeys
     * @return 删除成功的 数量
     */
    public Long hashDeleteByHk(String key, String... hashKeys) {
        return redisTemplate.opsForHash().delete(key, hashKeys);
    }

    /**
     * 给指定hash的hash-key做增减操作
     *
     * @param key
     * @param hashKey
     * @param number
     * @return
     */
    public Long hashSetIncrement(String key, String hashKey, long number) {
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    /**
     * 获取key下的 所有hash中key字段
     *
     * @param key
     * @return
     */
    public Set<Object> hashGetKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    /**
     * 获取key下的 所有hash中value字段
     *
     * @param key
     * @return
     */
    public List<Object> hashGetVals(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    /**
     * 获取指定 hash 下面的 键值对 数量
     *
     * @param key
     * @return
     */
    public Long hashGetSize(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    //- - - - - - - - - - - - - - - - - - - - -  set类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 将数据放入set缓存
     *
     * @param key 键
     * @return
     */
    public void setAdd(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
    }

    /**
     * 获取变量中的值
     *
     * @param key 键
     * @return
     */
    public Set<Object> setMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 随机获取变量中指定个数的元素
     *
     * @param key   键
     * @param count 提取数量
     * @return
     */
    public void setRandomMembers(String key, long count) {
        redisTemplate.opsForSet().randomMembers(key, count);
    }

    /**
     * 随机获取变量中的元素
     *
     * @param key 键
     * @return
     */
    public Object setRandomMember(String key) {
        return redisTemplate.opsForSet().randomMember(key);
    }

    /**
     * 弹出集合set中的元素
     *
     * @param key 键
     * @return
     */
    public Object setPop(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    /**
     * 获取集合set中元素数量
     *
     * @param key 键
     * @return
     */
    public long setGetSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 根据元素从一个set中查询是否存在
     *
     * @param key     键
     * @param element 元素
     * @return
     */
    public boolean setHasElement(String key, Object element) {
        return redisTemplate.opsForSet().isMember(key, element);
    }

    /**
     * 转移变量的元素值到目的变量
     *
     * @param originKey 源集合键
     * @param element   元素
     * @param destKey   目标集合键
     * @return
     */
    public boolean setMoveElement(String originKey, Object element, String destKey) {
        return redisTemplate.opsForSet().move(originKey, element, destKey);
    }

    /**
     * 批量移除set缓存中元素
     *
     * @param key    键
     * @param values 元素
     * @return
     */
    public void setRemove(String key, Object... values) {
        redisTemplate.opsForSet().remove(key, values);
    }

    //- - - - - - - - - - - - - - - - - - - - -  list类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 在变量左边添加元素值
     *
     * @param key
     * @param value
     * @return
     */
    public void listLeftPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 获取链表指定位置的值
     *
     * @param key
     * @param index
     * @return
     */
    public Object listGetElementByIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 获取链表指定区间的值
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> range(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 把最后一个参数值放到指定链表的第一个出现中间参数的前面
     * 如果中间参数值存在的话
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public void listLeftPush(String key, String pivot, String value) {
        redisTemplate.opsForList().leftPush(key, pivot, value);
    }

    /**
     * 向链表左边批量添加参数元素
     *
     * @param key
     * @param values
     * @return
     */
    public void listLeftPushAll(String key, Collection<Object> values) {
        redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * 向链表最右边添加元素
     *
     * @param key
     * @param value
     * @return
     */
    public void listLeftPushAll(String key, String value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 向链表左边批量添加参数元素
     *
     * @param key
     * @param values
     * @return
     */
    public void listRightPushAll(String key, Collection<Object> values) {
        redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * 向已存在的链表中添加元素
     *
     * @param key
     * @param value
     * @return
     */
    public void listRightPushIfPresent(String key, Object value) {
        redisTemplate.opsForList().rightPushIfPresent(key, value);
    }

    /**
     * 获取链表长度
     *
     * @param key
     * @return
     */
    public long listLength(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 移除链表中的左边第一个元素
     *
     * @param key
     * @return
     */
    public void listLeftPop(String key) {
        redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 移除链表中左边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出
     *
     * @param key
     * @return
     */
    public void listLeftPop(String key, long timeout, TimeUnit unit) {
        redisTemplate.opsForList().leftPop(key, timeout, unit);
    }

    /**
     * 移除链表中右边的元素
     *
     * @param key
     * @return
     */
    public void listRightPop(String key) {
        redisTemplate.opsForList().rightPop(key);
    }

    /**
     * 移除链表中右边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出
     *
     * @param key
     * @return
     */
    public void listRightPop(String key, long timeout, TimeUnit unit) {
        redisTemplate.opsForList().rightPop(key, timeout, unit);
    }
}
