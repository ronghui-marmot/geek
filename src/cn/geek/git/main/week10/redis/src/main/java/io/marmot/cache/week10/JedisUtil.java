package io.marmot.cache.week10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
    protected final static Logger logger = LoggerFactory.getLogger(JedisUtil.class);
    private static JedisPool jedisPool;

    @Autowired(required = true)
    public void setJedisPool(JedisPool jedisPool) {
        JedisUtil.jedisPool = jedisPool;
    }
    /**
     * 实现减库存
     * @author zhengrh
     * @param key 键
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setDecr(String key, long amount, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result =jedis.decrBy(key,amount);
            if (result<=1 && cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setDecr "+ key + " by " + amount);
        } catch (Exception e) {
            logger.warn("setDecr "+ key + " by " + amount);
        } finally {
            jedisPool.close();
        }
        return result;
    }
}
