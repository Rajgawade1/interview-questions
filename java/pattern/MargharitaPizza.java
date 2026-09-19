package com.demo.user.stream.pattern;

public class MargharitaPizza extends BasePizza {

  public MargharitaPizza() {
    description = "Margharita Pizza (Classic cheese and tomato base)";
  }
  public int cost(){
    System.out.println("MargharitaPizza cost is 100");
    return 100;
  }
}
