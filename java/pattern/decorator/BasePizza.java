package com.demo.user.stream.pattern.decorator;

public abstract class BasePizza {
  protected String description = "Unknown Pizza";

  public String getDescription() {
    return description;
  }
  abstract int cost();
}
