package com.example.demo.route;

import java.util.Date;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.example.demo.bean.TestBean;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Component
public class ActiveMQRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("jms:queue:test")
      .process(exchange -> {
        TestBean bean = exchange.getIn().getBody(TestBean.class);
        log.info("process jms : " + bean.toString());
        log.info("process jms JMSMessageID : {}", exchange.getIn().getHeader("JMSMessageID"));

      })
      .end();
    
  }
}
