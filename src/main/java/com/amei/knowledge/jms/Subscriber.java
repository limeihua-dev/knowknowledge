package com.amei.knowledge.jms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Receive
 */
@WebServlet("/Subscribe")
public class Subscriber extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subscriber() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            // get the initial context
            InitialContext ctx = new InitialContext();

            // lookup the topic object
            Topic topic = (Topic) ctx.lookup("java:comp/env/topic/topic0");

            // lookup the topic connection factory
            TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx
                    .lookup("java:comp/env/topic/connectionFactory");

            // create a topic connection
            TopicConnection topicConn = connFactory.createTopicConnection();

            // create a topic session
            TopicSession topicSession = topicConn.createTopicSession(false,
                    Session.AUTO_ACKNOWLEDGE);

            // create a topic subscriber
            TopicSubscriber topicSubscriber = topicSession
                    .createSubscriber(topic);

            // start the connection
            topicConn.start();

            // receive the message
            TextMessage message = (TextMessage) topicSubscriber.receive();

            // print the message
            out.write("Message received: " + message.getText());

            // close the topic connection
            topicConn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
