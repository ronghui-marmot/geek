package io.kimmking.javacourse.mq.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MarmotApplication {

    public static void main(String[] args){
        Destination destination = new ActiveMQQueue("marmot.queue");

        testDestination(destination);
    }

    public static void testDestination(Destination destination){
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61618");
            ActiveMQConnection conn = (ActiveMQConnection)factory.createConnection();
            conn.start();
            ActiveMQSession session = (ActiveMQSession)conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(destination);

            final AtomicInteger count = new AtomicInteger(0);
            MessageListener listener = new MessageListener() {
                @Override
                public void onMessage(Message message) {

                    System.out.println("message:" + message + count.incrementAndGet() + "-> receive from " + destination.toString());
                }
            };
            consumer.setMessageListener(listener);

            MessageProducer producer = session.createProducer(destination);
            int index = 0;
            while (index++ < 100) {
                TextMessage message = session.createTextMessage(index + " message.");
                producer.send(message);
            }

            Thread.sleep(2000);
            session.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
