package com.demo.user.stream.pattern;

public class TestClass {

  static void main() {
    // Order 2: A FarmHouse with double extra cheese and mushrooms
    BasePizza pizza2 = new FarmHousePizaa();
    pizza2 = new ExtraCheesePizza(pizza2);      // Wrap with cheese
    pizza2 = new ExtraCheesePizza(pizza2);      // Wrap with more cheese!
    pizza2 = new ExtraMushroomPizza(pizza2);    // Wrap with mushrooms

    System.out.println(pizza2.getDescription() + " | Cost: $" + pizza2.cost());
  }
}
