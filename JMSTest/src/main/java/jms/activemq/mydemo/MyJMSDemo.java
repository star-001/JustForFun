package jms.activemq.mydemo;

import javax.jms.JMSException;
public class MyJMSDemo {
    public static void main(String[] args) throws InterruptedException,JMSException {
        String url = "tcp://localhost:61616";
        String user = null;
        String password = null;
        String query = "MyQueueA";
        String topic = "TestTopic";


        new Thread(new MessageSubscriber(topic,url,user,password), "Name-Subscriber1").start();
        new Thread(new MessageSubscriber(topic,url,user,password), "Name-Subscriber2").start();
        new Thread(new MessageSubscriber(topic,url,user,password), "Name-Subscriber3").start();
        new Thread(new MessageSubscriber(topic,url,user,password), "Name-Subscriber4").start();
        new Thread(new MessageSubscriber(topic,url,user,password), "Name-Subscriber5").start();
        Thread.sleep(5000);
        new Thread(new MessagePublisher(topic,url,user,password), "Name-Publisher").start();

    }
}
