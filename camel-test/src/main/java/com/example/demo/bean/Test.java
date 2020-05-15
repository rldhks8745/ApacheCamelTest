package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Data
@Configuration
@EnableConfigurationProperties(TestVO.class)
public class Test {

  @Autowired
  TestVO testvo;
  
  public Test() {
    System.out.println("Test 생성자");
  }
  
  @Bean
  public Test createTest() throws Exception {
    System.out.println(testvo.toString());
    return this;
  }
}
