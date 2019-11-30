package rabbit;

import java.io.IOException;
import java.text.ParseException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Consumers {
	 private static final String Queue_Name="OTHE_MODI_MOPR_AOI_212848";
	 
	 
	    public static void main(String[] args) throws Exception {
			ConnectionFactory connectionFactory = new ConnectionFactory();
			connectionFactory.setHost("10.20.73.130");
			connectionFactory.setPort(5672);
			connectionFactory.setUsername("test");
			connectionFactory.setPassword("test");
			Connection connection = connectionFactory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(Queue_Name,true,false,false,null);
			System.out.println("等待消息的到来");
			
			Consumer consumer = new DefaultConsumer(channel) {
	            @Override
	            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, 
	            		byte[] body) throws IOException  {
	                String message = new String(body, "UTF-8");
	                System.out.println("消息是"+message);
	                
	                XIAOXI xiaoxi = JSON.parseObject(message,XIAOXI.class);
	                try {
						DoSql.add(xiaoxi);
					} catch (ParseException e) {
						e.printStackTrace();
					}
	                

	            }
	        };
	        channel.basicConsume(Queue_Name, true, consumer);       
		}
	    
	  
}
