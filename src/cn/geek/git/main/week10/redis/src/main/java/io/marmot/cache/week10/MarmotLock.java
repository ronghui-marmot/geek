package io.marmot.cache.week10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

@Service
public class MarmotLock {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private String lock_key = "marmot_lock";

    protected  long internalLockLeaseTime = 30000;  //锁过期时间
    private long timeout = 99999;

    SetParams params = SetParams.setParams().nx().px(internalLockLeaseTime);

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
                long l =System.currentTimeMillis();
                if(l>=timeout){
                    return false;
                }
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

        }finally {
            jedis.close();
        }
    }

    public boolean unlock(String id){
        Jedis jedis = jedisPool.getResource();
        String script =
                "if redis.call('get',KEYS[1])==AGRV[1] then"+
                        "   return redis.call('del',KEYS[1]) "+
                        "else" +
                        "   return 0 "+
                        "end";
        try {
            Object result = jedis.eval(script, Collections.singletonList(lock_key),
                    Collections.singletonList(id));
            if("1".equals(result.toString())){
                return  true;
            }
            return false;
        }finally {
            jedis.close();
        }
    }
}
