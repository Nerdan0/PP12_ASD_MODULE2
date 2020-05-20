package com.company;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = 0;
        int operation = 0;
        byte repeat = 1;
        int maxNumber = 0;
        int length = 0;
        int case1 = 0;

        ArrayList<Integer> maxNumbers = new ArrayList<Integer>();

        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Меню:");
        System.out.println("1 - додати елемент до стеку");
        System.out.println("2 - видалити елемент ці стеку");
        System.out.println("3 - вивести поточний найбільший елмент");

        while (repeat == 1){
            System.out.println("Введіть номер операції");

            operation = scanner.nextInt();
            if (operation > 3 || operation < 1) {
                System.out.println("Введено неправильний номер операції");
            }
            switch(operation) {
                case 1:
                    int number;
                    case1 += 1;

                    System.out.println("Введіть кількість елементів які хочете додати");
                    n = scanner.nextInt();
                    length += n;

                    for (int i = 0; i < n; i++) {
                        System.out.println("Введіть число №" + (i + 1));
                        number = scanner.nextInt();
                        stack.push(number);

                        if (number >= maxNumber) {
                            maxNumber = number;
                        }
                    }
                    maxNumbers.add(maxNumber);
                    break;
                case 2:
                    System.out.println("Вилучення числа " + stack.pop().toString());
                    break;
                case 3:
                    System.out.println("Найбільший елемент стеку на даний момент: " + maxNumber);
                    break;
            }
            System.out.println("Чи бажаєте викликати меню?");
            System.out.println("1 - так, 0 - ні");
            repeat = scanner.nextByte();
        }
        System.out.println("Фінальний стек:");
        for (int i = 0; i < length; i++) {
            System.out.print(stack.pop());
            System.out.print(",");
        }

        System.out.println("");
        System.out.println("Усі максимальні числа: ");
        for (int i = 0; i < case1; i++) {
            System.out.println(maxNumbers.get(i).toString());
        }
    }
}