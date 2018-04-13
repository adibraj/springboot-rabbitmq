package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.EmployeeServiceApplication;
import com.example.demo.Service.EmpPublish;

import io.netty.util.Constant;

@Configuration
public class RabbitConfig {
	
	@Value("${employee.queue.name}")
	public String empQName;
	@Value("${route.key}")
	public  String routingKey ;
	@Value("${exchange.name}")
	public  String exchange;
	@Bean
	public Queue empQueue() {
		return new Queue(empQName);
	}
	
	@Bean
	public FanoutExchange exchange() {
		return new FanoutExchange(exchange);
	}
	
	@Bean
	Binding empBinding() {
		return BindingBuilder.bind(empQueue()).to(exchange());
	}
	
	

	
	
	
}
