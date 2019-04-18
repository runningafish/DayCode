package cn.itcast.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicProducer {
    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.153:61616");
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建主题对象
        Topic topic = session.createTopic("test-topic");
        //创建消息的生产者
        MessageProducer producer = session.createProducer(topic);
        //消息对象
        TextMessage textMessage = session.createTextMessage("helloworld!!!!!");
        //发送
        producer.send(textMessage);
        //close
        producer.close();
        session.close();
        connection.close();
    }
}
