package test.task.baloon.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaloonConsumerApplication {
	
	static final String topicExchangeName = "baloon-data-exchange";
	
	static final String queueName = "baloon-data";
	
	@Bean
	public Queue queue() {
		return new Queue(queueName, false);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("baloon.data.#");
	}
	
	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}
	
	@Bean
	public MessageListenerAdapter listenerAdapter(BaloonDataReceiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BaloonConsumerApplication.class, args);
	}
	
}
