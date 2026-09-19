package com.demo.user.stream.pattern.decorator;

public class ExtraMushroomPizza extends PizzaDecorator {

  public ExtraMushroomPizza(BasePizza basePizza) {
    super(basePizza);
  }
  @Override
  public String getDescription() {
    return basePizza.getDescription() + ", Extra Mushroom";
  }

  public int cost(){
    System.out.println("ExtraMushroomPizza cost is " + (this.basePizza.cost() +10));
    return this.basePizza.cost()+20;
  }
}
