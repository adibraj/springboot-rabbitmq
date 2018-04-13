package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.BindingFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Value("${employee.queue.name}")
	String queueName;
	@Value("${exchange.name}")
	String exchange;
	@Value("${route.key}")
	String routeKey;
	
	@Bean
	public Queue empQueue()
	{
		return new Queue(queueName);
	}
	
	@Bean 
	public TopicExchange exchage()
	{
		return new TopicExchange(exchange);
	}
	
	@Bean
	public Binding bindQueue() {
		return BindingBuilder.bind(empQueue()).to(exchage()).with(routeKey);
	}
	
	
}
