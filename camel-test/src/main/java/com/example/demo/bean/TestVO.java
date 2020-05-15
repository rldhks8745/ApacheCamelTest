package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties(prefix="test")
public class TestVO {
  
  private int age;
  
  private String name;
  
  public TestVO() {
    System.out.println("TestVO 생성자");
  }
  
  @Override
  public String toString() {
    return String.format("age:%d, name:%s", age, name);
  }
}
