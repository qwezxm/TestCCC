package rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {
    private static final String Queue_Name="hellos";
    public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(Queue_Name,false,false,false,null);
		String message="ha la me";
		channel.basicPublish("", Queue_Name, null, message.getBytes("UTF-8"));
		System.out.println("消息已发送");
		channel.close();
		connection.close();
		
	}
    
}
