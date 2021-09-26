package com.bad_java.homework.hyperskill.Simple_tic_tac_toe;

import java.util.Scanner;

public class Main {
  final static Scanner scanner = new Scanner(System.in);


  static int countCondX1 = 0;
  static int countCondX2 = 0;
  static int countCondX3 = 0;
  static int countCondX4 = 0;
  static int countCondX5 = 0;
  static int countCondX6 = 0;
  static int countCondX7 = 0;
  static int countCondX8 = 0;


  public static void main(String[] args) {
    int counterX = 0;
    int counterO = 0;
    System.out.print("Enter cells: ");
    String str = scanner.nextLine();

    char[][] ticTakToe = new char[3][3];
    for (int i = 0; i < ticTakToe.length; i++) {
      for (int j = 0; j < ticTakToe[i].length; j++) {
        ticTakToe[0][j] = str.charAt(j);
        ticTakToe[1][j] = str.charAt(j + 3);
        ticTakToe[2][j] = str.charAt(j + 6);

        if (ticTakToe[i][j] == 'X') {
          counterX++;
        }
        if (ticTakToe[i][j] == 'O') {
          counterO++;
        }
      }
    }
    System.out.println("---------");
    System.out
        .println("| " + ticTakToe[0][0] + " " + ticTakToe[0][1] + " " + ticTakToe[0][2] + " |");
    System.out
        .println("| " + ticTakToe[1][0] + " " + ticTakToe[1][1] + " " + ticTakToe[1][2] + " |");
    System.out
        .println("| " + ticTakToe[2][0] + " " + ticTakToe[2][1] + " " + ticTakToe[2][2] + " |");
    System.out.println("---------");

    System.out.print("Enter the coordinates: ");

    int[] coordinates = new int[2];
    int idx = 0;

    while (idx < 2) {
      if (scanner.hasNextInt()) {
        coordinates[idx] = scanner.nextInt();
        if (coordinates[idx] > 0 && coordinates[idx] < 4) {
          idx++;
        } else {
          System.out.println("Coordinates should be from 1 to 3!");
          System.out.print("Enter the coordinates: ");
          scanner.nextLine();
        }
      } else {
        System.out.println("You should enter numbers!");
        System.out.print("Enter the coordinates: ");
        scanner.nextLine();
      }
    }

    int coordinatesX = coordinates[0] - 1;
    int coordinatesY = coordinates[1] - 1;


    while (Math.abs(counterX - counterO) == 1 || counterO == counterX) {

      if (ticTakToe[coordinatesX][coordinatesY] == '_') {
        ticTakToe[coordinatesX][coordinatesY] = 'X';
        System.out.println("---------");
        System.out
            .println("| " + ticTakToe[0][0] + " " + ticTakToe[0][1] + " " + ticTakToe[0][2] + " |");
        System.out
            .println("| " + ticTakToe[1][0] + " " + ticTakToe[1][1] + " " + ticTakToe[1][2] + " |");
        System.out
            .println("| " + ticTakToe[2][0] + " " + ticTakToe[2][1] + " " + ticTakToe[2][2] + " |");
        System.out.println("---------");

        for (int i = 0; i < ticTakToe.length; i++) {
          for (int j = 0; j < ticTakToe[i].length; j++) {
            if (i == j && ticTakToe[i][i] == 'X') {
              countCondX1++;
            }
            if (j == 2 - i && ticTakToe[i][2 - i] == 'X') {
              countCondX2++;
            }
            if (i == 0 && ticTakToe[0][j] == 'X') {
              countCondX3++;
            }
            if (i == 1 && ticTakToe[1][j] == 'X') {
              countCondX4++;
            }
            if (i == 2 && ticTakToe[2][j] == 'X') {
              countCondX5++;
            }

            if (j == 0 && ticTakToe[i][0] == 'X') {
              countCondX6++;
            }
            if (j == 1 && ticTakToe[i][1] == 'X') {
              countCondX7++;
            }
            if (j == 2 && ticTakToe[i][2] == 'X') {
              countCondX8++;
            }
          }
        }
        if (countCondX3 == 3 || countCondX4 == 3 || countCondX5 == 3 || countCondX6 == 3 || countCondX7
            == 3 || countCondX8 == 3) {
          break;
        }
        counterX++;
      } else {
        if (Math.abs(counterX - counterO) == 1) break;
        System.out.println("This cell is occupied! Choose another one!");
        System.out.println("Enter the coordinates:");
        checkCoordinates();
        if (ticTakToe[coordinatesX][coordinatesY] == '_') {
          ticTakToe[coordinatesX][coordinatesY] = 'X';
          System.out.println("---------");
          System.out
              .println(
                  "| " + ticTakToe[0][0] + " " + ticTakToe[0][1] + " " + ticTakToe[0][2] + " |");
          System.out
              .println(
                  "| " + ticTakToe[1][0] + " " + ticTakToe[1][1] + " " + ticTakToe[1][2] + " |");
          System.out
              .println(
                  "| " + ticTakToe[2][0] + " " + ticTakToe[2][1] + " " + ticTakToe[2][2] + " |");
          System.out.println("---------");
        }
      }
    }


  }


  static void checkCoordinates () {
    int[] coordinates = new int[2];
    int idx = 0;

    while (idx < 2) {
      if (scanner.hasNextInt()) {
        coordinates[idx] = scanner.nextInt();
        if (coordinates[idx] > 0 && coordinates[idx] < 4) {
          idx++;
        } else {
          System.out.println("Coordinates should be from 1 to 3!");
          System.out.print("Enter the coordinates: ");
          scanner.nextLine();
        }
      } else {
        System.out.println("You should enter numbers!");
        System.out.print("Enter the coordinates: ");
        scanner.nextLine();
      }
    }
  }



}



//    boolean condition1 = countCodnX1 == 3 || countCodnX2 == 3 || countCodnX3 == 3 || countCodnX4 == 3 || countCodnX5 == 3 || countCodnX6 == 3 || countCodnX7 == 3 || countCodnX8 == 3;
//    boolean condition2 = countCodnO1 == 3 || countCodnO2 == 3 || countCodnO3 == 3 || countCodnO4 == 3 || countCodnO5 == 3 || countCodnO6 == 3 || countCodnO7 == 3 || countCodnO8 == 3;
//
//    if (Math.abs(counterX - counterO) > 1) {
//      System.out.println("Impossible");
//    }
//    if (countCodnX6 == 3 && countCodnO7 == 3 || countCodnX6 == 3 && countCodnO8 ==3) {
//      System.out.println("Impossible");
//    }
//    if (countCodnO6 == 3 && countCodnX7 == 3 || countCodnO6 == 3 && countCodnX8 ==3) {
//      System.out.println("Impossible");
//    }
//    if (countCodnX3 == 3 && countCodnO4 == 3 || countCodnX3 == 3 && countCodnO5 == 3) {
//      System.out.println("Impossible");
//    }
//    if (countCodnO3 == 3 && countCodnX4 == 3 || countCodnO3 == 3 && countCodnX5 == 3) {
//      System.out.println("Impossible");
//    }
//    if (counter_ == 0 && (!condition1 || !condition2)) {
//      System.out.println("Draw");
//    }
//
//    if (condition1 && !condition2) {
//      System.out.println("X wins");
//    }
//    if (condition2 && !condition1) {
//      System.out.println("O wins");
//    }
//  }
