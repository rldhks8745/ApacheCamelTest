package com.example.demo.route;

import java.util.Date;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.bean.TestBean;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Component
public class TimerRoute extends RouteBuilder {
  
  private final int checkTime = 100000; 
  
  @Override
  public void configure() throws Exception {
    
    from("timer://timerRoute1?period=" + checkTime).routeId("timerRoute1")
      .process(exchange -> {
        ObjectMapper mapper = new ObjectMapper();
        TestBean bean = mapper.readValue("{\"age\":15,\"name\":\"김기완\"}", TestBean.class);
        
        log.info("process timer : " + bean.toString());
        exchange.getIn().setBody(bean);
      })
    .to("jms:queue:test")
      .process(exchange -> {
        log.info("after jms : " + exchange.getIn().getBody().toString());
      });
    
  }
}
