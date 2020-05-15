package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class TestBean2 {

  private int age = 15; // 8byte
  private String name = "홍길동"; // 비워두기
  
  public TestBean2() {
  }
}
