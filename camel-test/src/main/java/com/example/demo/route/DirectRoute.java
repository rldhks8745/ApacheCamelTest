package com.example.demo.route;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

public class DirectRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("direct:a").routeId("DirectRoute")
      .process(exchange -> {
        log.info("receive direct:a");
        log.info("sleep 전");
        Thread.sleep(1000);
        log.info("sleep 후");
        Message message = exchange.getIn(Message.class);
        log.info("header : "+message.getHeader("t"));
        log.info("body : "+message.getBody(String.class).toString());
      });
    
  }
}
