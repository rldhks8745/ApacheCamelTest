package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class TimerRoute2 extends RouteBuilder {
  private final int checkTime = 5000; 
  
  @Override
  public void configure() throws Exception {
    
    from("timer://timerRoute2?period=" + checkTime).routeId("timerRoute2")
      .process(exchange -> {
        exchange.getIn().setBody("test2에게 이 메세지 보네기");
      })
      .log("TimerRoute2 send to jms:queue:test2")
    .to("jms:queue:test2?");
    
  }
}
