package test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitTest {
	  private static final String EXCHANGE_NAME = "logs";  
	  
	    public static void main(String[] argv) throws Exception{  
	  
	        ConnectionFactory factory = new ConnectionFactory();  
	        //rabbitmq监听IP  
	        factory.setHost("120.55.163.146");  
	        //rabbitmq监听默认端口  
	        factory.setPort(15672);  
	        //设置访问的用户  
	        factory.setUsername("e3develop");  
	        factory.setPassword("pico2017");  
	        Connection connection = factory.newConnection();  
	        Channel channel = connection.createChannel();  
	  
	        //声明路由名字和类型  
	        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");  
	        String message = makeMessage(argv);  
	          
	        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());  
	        System.out.println("Sent msg is '" + message + "'");  
	  
	        channel.close();  
	        connection.close();  
	    }  
	  
	    private static String makeMessage(String[] strings){  
	        if (strings.length < 1){  
	            return "这是默认消息！！";  
	        }else{  
	            StringBuffer buffer= new StringBuffer();  
	            for (int i = 0; i < strings.length; i++) {  
	                buffer.append(strings[i]);  
	            }  
	            return buffer.toString();  
	        }  
	    }  
}
