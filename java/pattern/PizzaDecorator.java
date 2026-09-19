package com.demo.user.stream.pattern;

public abstract class PizzaDecorator extends BasePizza {

  BasePizza basePizza;

  public PizzaDecorator(BasePizza basePizza){
    this.basePizza = basePizza;
  }
  // Force decorators to re-implement description to append toppings
  public abstract String getDescription();
}
