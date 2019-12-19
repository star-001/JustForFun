package jms.activemq.mydemo;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSubscriber implements Runnable {
    private String url;
    private String user;
    private String password;
    private String topicName;

    public MessageSubscriber(String topicName, String url, String user,
                             String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.topicName = topicName;
    }

    @Override
    public void run() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                user, password, url);
        Session session = null;
        MessageConsumer subscriber;
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // 创建Topic
            Topic topic = session.createTopic(this.topicName);

            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            subscriber = session.createConsumer(topic);
            subscriber.setMessageListener(new TextListener());
            connection.start();

            System.out.println(Thread.currentThread().getName() + "开启");

            // connection.close();
        } catch (JMSException e) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTopic() {
        return topicName;
    }
}