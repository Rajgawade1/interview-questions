package com.demo.user.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class has static methods to showcase how to solve different list, string manipulation problems using stream apis
 */
public class StreamPractice {

  public static void main(String[] args) {

    List<String> stringList = new ArrayList<>(List.of("Java", "COBOL", "C#", "Python", "This is max length string"));
    System.out.println("Max length string : " + getMaxLengthStringFromList(stringList) +"\n");

    List<Integer> intList = new ArrayList<>(List.of(1, 4, 11, 211, 111, 1, 4, 3, 3, 111, 3));
    System.out.println("Integer starts with 1 : " + getListOfIntegersStartingWith(intList,'1')+"\n");

    System.out.println("Duplicate Integers : " + getDuplicateElementsFromList(intList)+"\n");

    String inputString = "abv335777";
    
    System.out.println("String - " + inputString + ", characters from it : " + printCharsFromString(inputString)+"\n");


    System.out.println("String - " + inputString + " digits from it : " + printDigitsFromString(inputString)+"\n");

  }

  /**
   * To print characters from String
   * @param input
   * @return
   */
  public static String printCharsFromString(String input) {
    return input.chars().filter(Character::isLetter).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
  }

  /**
   * To print digits from string
   * @param input
   * @return
   */
  public static String printDigitsFromString(String input) {
    return input
            .chars()
            .filter(Character::isDigit)
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining());
  }

  /**
   * To find max length string from list of strings
   * @param input
   * @return
   */
  public static String getMaxLengthStringFromList(List<String> input) {
    return input
            .stream()
            .max(Comparator.comparingInt(String::length))
            .orElse("");
  }

  /**
   * To find list of integers starting with given char
   * @param input
   * @return
   */
  public static List<Integer> getListOfIntegersStartingWith(List<Integer> input,char c) {
    return input
            .stream()
            .map(String::valueOf)
            .filter(s -> s.startsWith(String.valueOf(c)))
            .map(Integer::valueOf)
            .distinct()
            .collect(Collectors.toList());
  }

  /**
   * To find duplicate elements from given list of integers
   * @param input
   * @return
   */
  public static List<Integer> getDuplicateElementsFromList(List<Integer> input) {
    HashSet<Integer> seen = new HashSet<>();
    return input
            .stream()
            .filter(a -> !seen.add(a))
            .distinct()
            .toList();
  }

}
