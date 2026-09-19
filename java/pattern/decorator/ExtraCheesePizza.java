package com.demo.user.stream.pattern.decorator;

public class ExtraCheesePizza extends PizzaDecorator {

  public ExtraCheesePizza(BasePizza basePizza) {
    super(basePizza);
  }

  @Override
  public String getDescription() {
    return basePizza.getDescription() + ", Extra Cheese";
  }

  public int cost(){
    System.out.println("ExtraCheesePizza cost is " + (this.basePizza.cost() +10));
    return this.basePizza.cost()+10;
  }
}
