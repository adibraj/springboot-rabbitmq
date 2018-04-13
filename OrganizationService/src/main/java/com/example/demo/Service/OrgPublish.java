package com.example.demo.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Employee;


@Service
public class OrgPublish {
	Logger log = LoggerFactory.getLogger(OrgPublish.class);
	
	
	RabbitTemplate template;
	TopicExchange exchange;
	
	
	@Autowired
	public OrgPublish(RabbitTemplate template,TopicExchange exchange)
	{
		this.template = template;
		this.exchange = exchange;
	}
	
	public void sendEmpMessage(Employee emp)
	{
		template.convertAndSend(exchange.getName(),"employee.create",emp);
	}
	
	@RabbitListener(queues="empQueue")
	public void receive(Employee emp)
	{
		log.info("Employee "+emp+"received at Organization Service");
		
	}
}
