package com.demo.user.stream.pattern;

public class FarmHousePizaa extends BasePizza {

  public FarmHousePizaa() {
    description = "FarmHouse Pizza (Topped with capsicum, onion, tomato, and grilled mushroom)";
  }

  public int cost(){
    System.out.println("FarmHouse Pizza  cost is 200");
    return 200;
  }
}
