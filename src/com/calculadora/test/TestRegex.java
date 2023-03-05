package com.calculadora.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
  public static void main(String[] args) {
    String expression = "1+2*3-4/5";
    String regex = "\\d+|[\\+\\-\\*\\/]";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(expression);

    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}
