package com.example.demo.bean;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class TestBean implements Serializable {
  private int age;
  private String name;
  
  public TestBean() {
  }
  
  @Override
  public String toString() {
    return String.format("age:%d, name:%s", age, name);
  }
}
