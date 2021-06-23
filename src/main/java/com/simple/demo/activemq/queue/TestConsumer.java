package com.simple.demo.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TestConsumer {

    private static final String USERNAME= "admin" ;
    private static final String PASSWORD = "admin" ;
    private static final String URL = "tcp://192.168.56.129:61616";

    public static void main(String[] args) {
        new TestConsumer().receiveMessage();
    }

    private void receiveMessage() {
        ConnectionFactory factory = null;
        Session session = null;
        MessageConsumer consumer = null;
        Destination destination = null;
        Message message = null;
        factory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, URL);
        Connection connection = null;
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);//表示是否支持事务，及如何确认消息机制
            destination = session.createQueue("charles's 1st queue");
            consumer = session.createConsumer(destination);
            message = consumer.receive();
            System.out.println(((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            close(consumer, session, connection);
        }

    }

    private void close(MessageConsumer consumer, Session session, Connection connection) {
        try {
            if (consumer != null) {
                consumer.close();
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
