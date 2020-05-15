package com.example.demo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.bean.Test;

@Configuration
public class JmsConfig {

  @Autowired
  ActiveMQConnectionFactory amqFactory;
  
  @Autowired
  JmsComponent jmsComponent;
  
  @Autowired
  @Qualifier(value="createTest")
  Test test;
  
  @Bean
  public JmsConfig JmsConfig() {
    jmsComponent.setConnectionFactory(amqFactory);
    System.out.println("setJmsConnectionFactory");
    System.out.println(test.getTestvo().toString());
    
    return this;
  }
}
