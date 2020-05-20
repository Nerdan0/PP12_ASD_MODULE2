//Пелішенко ПП-12 Варіант 6 Завдання 2
//Не повністю закінчена
//Може сказати коли стеки одразу мають однакову вагу
//Може урівняти стеки якщо при відніманні елемента вага стеку не стає менше ваги іншого стеку
package com.company;

import java.util.Stack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        Scanner scanner = new Scanner(System.in);

        int n1 = 0, n2 = 0, n3 = 0;
        int weight = 0;
        int stack1Weight = 0, stack2Weight = 0, stack3Weight = 0;

        System.out.print("Введіть кількість елементів стеку №1:");
        n1 = scanner.nextInt();
        System.out.println("");
        System.out.print("Введіть кількість елементів стеку №2:");
        n2 = scanner.nextInt();
        System.out.println("");
        System.out.print("Введіть кількість елементів стеку №3:");
        n3 = scanner.nextInt();
        System.out.println("");

        System.out.println("Стек 1");
        for (int i = 0; i < n1; i++) {
            System.out.print("Введіть вагу елементу №" + (i + 1));
            weight = scanner.nextInt();
            stack1.push(weight);
            stack1Weight += weight;
            System.out.println("");
        }

        System.out.println("Стек 2");
        for (int i = 0; i < n2; i++) {
            System.out.print("Введіть вагу елементу №" + (i + 1));
            weight = scanner.nextInt();
            stack2.push(weight);
            stack2Weight += weight;
            System.out.println("");
        }

        System.out.println("Стек 3");
        for (int i = 0; i < n3; i++) {
            System.out.print("Введіть вагу елементу №" + (i + 1));
            weight = scanner.nextInt();
            stack3.push(weight);
            stack3Weight += weight;
            System.out.println("");
        }

        System.out.println("Вага стеків:" + stack1Weight + " " + stack2Weight + " " + stack3Weight);

        if (stack1Weight == stack2Weight && stack1Weight == stack3Weight) {
            System.out.println("Загальна вага стеків однакова, елементи не потрібно видаляти");
        } else if (stack1Weight <= stack2Weight && stack1Weight <= stack3Weight) {
            while (stack1Weight != stack2Weight) {
                stack2Weight -= stack2.pop();
            }

            while (stack1Weight != stack3Weight) {
                stack3Weight -= stack3.pop();
            }
        } else if (stack2Weight <= stack1Weight && stack2Weight <= stack3Weight) {
            while (stack2Weight != stack1Weight) {
                stack1Weight -= stack1.pop();
            }
            while (stack2Weight != stack3Weight) {
                stack3Weight -= stack3.pop();
            }
        } else if (stack3Weight <= stack2Weight && stack3Weight <= stack1Weight) {
            while (stack3Weight != stack2Weight) {
                stack2Weight -= stack2.pop();
            }
            while (stack3Weight != stack1Weight) {
                stack1Weight -= stack1.pop();
            }
        }

        System.out.println("Тепер загальна вага кожного стеку " + stack1Weight);

        System.out.println("Фінальний стек 1:");
        for (int i = 0; i < n1; i++) {
            System.out.print(stack1.pop());
            System.out.print(" ");
        }

        System.out.println("Фінальний стек 2:");
        for (int i = 0; i < n2; i++) {
            System.out.print(stack1.pop());
            System.out.print(" ");
        }

        System.out.println("Фінальний стек 3:");
        for (int i = 0; i < n3; i++) {
            System.out.print(stack1.pop());
            System.out.print(" ");
        }
    }
}
