package jms.activemq.mydemo;

import java.util.Date;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessagePublisher implements Runnable {
    private String url;
    private String user;
    private String password;
    private String topicName;

    public MessagePublisher(String topicName, String url, String user,
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
        MessageProducer sendPublisher;
        Connection connection = null;

        int messageCount = 0;
        try {
            connection = connectionFactory.createConnection();

            connection.start();

            //创建Topic
            //Topic topic = new ActiveMQTopic(this.topicName);
            session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(this.topicName);
            sendPublisher = session.createProducer(topic);
            while (true) {
                String text = new Date() + "现在发送是第" + messageCount + "条消息";

                sendPublisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                sendPublisher.send(session.createTextMessage(text));

                if ((++messageCount) == 3) {
                    // 发够十条消息退出
                    break;
                }
                Thread.sleep(1000);
            }

            //sendPublisher.close();

            //connection.close();

            System.out.println("发布消息线程结束！！！！！！！！！！！！！！！！！！！！！！！！");
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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