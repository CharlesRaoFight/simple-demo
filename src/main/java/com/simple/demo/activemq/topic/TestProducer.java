package com.simple.demo.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TestProducer {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String URL = "tcp://192.168.56.129:61616";


    public static void main(String[] args) {
        new TestProducer().sendMessage("xiaofeng ,i love you");
    }

    private void sendMessage(String msg) {
        ConnectionFactory factory = null;
        Session session = null;
        MessageProducer producer = null;
        Destination destination = null;
        Message message = null;
        factory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, URL);
        Connection connection = null;
        try {
            connection.start();
            connection = factory.createConnection();
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);//表示是否支持事务，及如何确认消息机制
            destination = session.createTopic("charles's 1st topic");
            producer = session.createProducer(destination);
            message = session.createTextMessage(msg);
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            close(producer, session, connection);
        }

    }

    private void close(MessageProducer producer, Session session, Connection connection) {
        try {
            if (producer != null) {
                producer.close();
            }
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}
