package cn.itcast.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class TopicConsumer {
    public static void main(String[] args) throws JMSException, IOException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.153:61616");
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列对象
        Topic topic = session.createTopic("test-topic");
        //创建消费者对象
        MessageConsumer consumer = session.createConsumer(topic);
        //设置监听
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("提取的信息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });
        //等待键盘输入
        System.in.read();
        //close
        consumer.close();
        session.close();
        connection.close();
    }
}
