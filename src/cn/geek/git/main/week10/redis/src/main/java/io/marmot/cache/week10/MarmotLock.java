package io.marmot.cache.week10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

@Service
public class MarmotLock {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private String lock_key = "marmot_lock";

    protected  long internalLockLeaseTime = 30000;  //锁过期时间
    private long timeout = 99999;

    SetParams params = SetParams.SetParams().nx().px(internalLockLeaseTime);

    @Autowired
    JedisPool jedisPool;

    public boolean lock(String id){
        Jedis jedis = jedisPool.getResource();
        Long start = System.currentTimeMillis();

        try{
            for(;;){
                String lock = jedis.set(lock_key,id,params);
                if("OK".equals(lock)){
                    return true;
                }
            }

        }
    }
}
