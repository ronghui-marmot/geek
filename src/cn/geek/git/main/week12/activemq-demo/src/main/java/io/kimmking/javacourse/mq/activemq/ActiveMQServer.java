package io.kimmking.javacourse.mq.activemq;

import org.apache.activemq.broker.BrokerService;

public class ActiveMQServer {

    public static void main(String[] args) {
        try {
            // 尝试用java代码启动一个ActiveMQ broker server
            // 然后用前面的测试demo代码，连接这个嵌入式的server
            BrokerService brokerService = new BrokerService();
            brokerService.setUseJmx(true);
            brokerService.addConnector("tcp://127.0.0.1:61618");
            brokerService.start();
            System.in.read();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
