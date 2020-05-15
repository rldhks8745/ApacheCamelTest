package com.example.demo.route;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

public class HttpRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("netty4-http:http://localhost:8888/test").routeId("HttpRoute")
      .setHeader("t", constant("v"))
      .process(exchange -> {
        log.info("receive netty4-http");
        Message message = exchange.getIn(Message.class);
        log.info("header : "+message.getHeader("t"));
        message.setBody("<div style='color:red'>good</div>");
        log.info("body : "+message.getBody(String.class).toString());
      })
    .setHeader("t", constant("t"))
    .to("direct:a")
      .setHeader("t", constant("t2"))
      .process(exchange -> {
        log.info("after direct:a");
        Message message = exchange.getIn(Message.class);
        message.setBody("<div style='color:blue'>good</div>");
        log.info("header : "+message.getHeader("t"));
        log.info("body : "+message.getBody(String.class).toString());
      });
    
  }
}
