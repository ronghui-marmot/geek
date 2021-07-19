package io.marmot.cache.week10;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    MarmotLock redisLock;
    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1, 1);
    int count = 0;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/index")
    @ResponseBody
    public String index() throws InterruptedException {

        int clientcount =1000;
        CountDownLatch countDownLatch = new CountDownLatch(clientcount);

        ExecutorService executorService = Executors.newFixedThreadPool(clientcount);
        long start = System.currentTimeMillis();

        for (int i = 0;i<clientcount;i++){
            executorService.execute(() -> {

                //通过Snowflake算法获取唯一的ID字符串
                String id = String.valueOf(idWorker.nextId());
                try {
                    redisLock.lock(id);
                    count++;
                }finally {
                    redisLock.unlock(id);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        logger.info("执行线程数:{},总耗时:{},count数为:{}",clientcount,end-start,count);
        return "Hello";
    }
}
