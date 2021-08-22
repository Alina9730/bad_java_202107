package com.bad_java.homework.hyperskill.coffe_machine.part5;

import java.util.Scanner;

public class CoffeeMachine5 {

  final static Scanner scanner = new Scanner(System.in);
  final static CoffeeType ESPRESSO = new CoffeeType(250, 0, 16, 4);
  final static CoffeeType LATTE = new CoffeeType(350, 75, 20, 7);
  final static CoffeeType CAPPUCCINO = new CoffeeType(200, 100, 12, 6);

  static int amountWater = 400;
  static int amountMilk = 540;
  static int amountCoffeeBeans = 120;
  static int amountCupsCoffee = 9;
  static int amountMoney = 550;

  public static void main(String[] args) {
    String action = "";
    while (!action.equals("exit")) {
      System.out.println("Write action (buy, fill, take, remaining, exit): ");
      action = scanner.nextLine();
      switch (action) {
        case "buy":
          buyCoffee();
          break;
        case "fill":
          fillIngredients();
          break;
        case "take":
          takeMoney();
          break;
        case "remaining":
          remainingIngredients();
          break;
        case "exit":
          break;
      }
    }
  }

  static void buyCoffee() {
    System.out.println(
        "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
    int num = 0;
    String back = "";
    if (scanner.hasNextInt()) {
      num = scanner.nextInt();
    } else {
      back = scanner.nextLine();
    }

    if (num == 1) buyCoffee(ESPRESSO);
    if (num == 2) buyCoffee(LATTE);
    if (num == 3) buyCoffee(CAPPUCCINO);
    if (back.equals("back")) {
      System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

  }

  static void buyCoffee(CoffeeType coffeeType) {
    if (amountWater >= coffeeType.water && amountCoffeeBeans >= coffeeType.coffeeBeans && amountCupsCoffee >= 1) {
      amountWater = amountWater - coffeeType.water;
      amountCoffeeBeans = amountCoffeeBeans - coffeeType.coffeeBeans;
      amountMoney = amountMoney + coffeeType.cost;
      amountCupsCoffee = amountCupsCoffee - 1;
      System.out.println("I have enough resources, making you a coffee!");
    } else {
      if (amountWater < coffeeType.water) {
        System.out.println("Sorry, not enough water!");
      }
      if (amountCoffeeBeans < coffeeType.coffeeBeans) {
        System.out.println("Sorry, not enough coffee beans!");
      }
      if (amountCupsCoffee == 0) {
        System.out.println("Sorry, not enough disposable cups!");
      }
    }
  }

  static void fillIngredients() {
    System.out.println("Write how many ml of water you want to add: ");
    int addWater = scanner.nextInt();
    System.out.println("Write how many ml of milk you want to add: ");
    int addMilk = scanner.nextInt();
    System.out.println("Write how many grams of coffee beans you want to add: ");
    int addCoffeeBeans = scanner.nextInt();
    System.out.println("Write how many disposable cups of coffee you want to add: ");
    int addDisposable = scanner.nextInt();
    amountWater = amountWater + addWater;
    amountMilk = amountMilk + addMilk;
    amountCoffeeBeans = amountCoffeeBeans + addCoffeeBeans;
    amountCupsCoffee = amountCupsCoffee + addDisposable;
  }

  static void takeMoney() {
    System.out.println("I gave you $" + amountMoney);
    amountMoney = 0;
  }

  static void remainingIngredients() {
    System.out.println("The coffee machine has:");
    System.out.println(amountWater + " ml of water");
    System.out.println(amountMilk + " ml of milk");
    System.out.println(amountCoffeeBeans + " g of coffee beans");
    System.out.println(amountCupsCoffee + " disposable cups");
    System.out.println("$" + amountMoney + " of money");
  }

}
