package com.demo.user.stream.pattern;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

  /*public static void main(String[] args) {


    // Order 1: A plain Margharita
    BasePizza pizza1 = new MargharitaPizza();
    System.out.println(pizza1.getDescription() + " | Cost: $" + pizza1.cost());

    // Order 2: A FarmHouse with double extra cheese and mushrooms
    BasePizza pizza2 = new FarmHousePizaa();
    pizza2 = new ExtraCheesePizza(pizza2);      // Wrap with cheese
    pizza2 = new ExtraCheesePizza(pizza2);      // Wrap with more cheese!
    pizza2 = new ExtraMushroomPizza(pizza2);    // Wrap with mushrooms

    System.out.println(pizza2.getDescription() + " | Cost: $" + pizza2.cost());
  }*/

  private static final int THREAD_COUNT = 5;
  private static final int ITERATIONS = 500_000;

  public static void main(String[] args) throws InterruptedException {
    Map<String, Integer> hashtable = new Hashtable<>();
    Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();

    // Test Legacy Hashtable
    long timeHashtable = runWorkerThreads(hashtable);
    System.out.println("Hashtable Execution Time: " + timeHashtable + " ms");

    // Test Modern ConcurrentHashMap
    long timeConcurrent = runWorkerThreads(concurrentMap);
    System.out.println("ConcurrentHashMap Execution Time: " + timeConcurrent + " ms");

    System.out.println("Performance Gain: " + (timeHashtable / timeConcurrent) + "x faster!");
  }

  private static long runWorkerThreads(Map<String, Integer> map) throws InterruptedException {
    long startTime = System.currentTimeMillis();
    ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    for (int i = 0; i < THREAD_COUNT; i++) {
      final int threadId = i;
      executor.execute(() -> {
        for (int j = 0; j < ITERATIONS; j++) {
          // Distribute keys across multiple internal buckets
          String key = "Key-" + (j % 100);
          map.put(key, threadId + j);
          map.get(key);
        }
      });
    }

    executor.shutdown();
    executor.awaitTermination(10, TimeUnit.SECONDS);
    return System.currentTimeMillis() - startTime;
  }


}
