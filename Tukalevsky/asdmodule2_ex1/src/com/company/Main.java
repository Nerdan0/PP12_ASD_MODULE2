//Tukalevsky var18 ex1

package com.company;
import java.lang.String;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList max= new LinkedList<Integer>();
        Stack stack = new Stack(); //стек
        MENU(stack,max);
    }

    public static void MENU(Stack stack, LinkedList max) {

        System.out.println("Меню");
        System.out.println("1 - Добавление элемента в стек");
        System.out.println("2 - Удаление элемента из стека");
        System.out.println("3 - Самое больше значение стека");
        System.out.println("0 - Выход из программы");
        System.out.print("Введите номер задания: ");

        Scanner input = new Scanner(System.in);

        int pointer = 0;
        try {
            pointer = input.nextInt();
            if (pointer < 0 || pointer > 3) { //Проверка на правильный ввод цифр меню (допустимо 1-7)
                System.out.println("Вы ввели неправильные данные, повторите попытку");
                MENU(stack,max);
            }
        } catch (java.util.InputMismatchException e) { //Проверка на ввод других символов/букв
            System.out.println("Вы ввели неправильные данные, повторите попытку");
            MENU(stack,max);
        }
        switch (pointer) {

            case 1:
                System.out.println("Добавление элемента в стек");
                System.out.print("Введите элемент, который хотите добавить в стек: ");

                try {
                    int a = input.nextInt();
                    max.add(a);
                    stack.add(a);
                    System.out.println("Элемент добавлен");
                } catch (java.util.InputMismatchException e) { //Проверка на ввод других символов/букв
                    System.out.println("Ошибка");
                }
                System.out.print("Стек: ");
                stack.display();
                System.out.println();
                MENU(stack,max);
            case 2:
                System.out.println("Удаление элемента из стека");

                stack.remove();
                max.removeLast();
                System.out.println("Элемент удалён");
                System.out.print("Стек: ");
                stack.display();
                System.out.println();
                MENU(stack,max);
            case 3:
                int maxtemp = 0;
                for(int i = 0; i < max.size(); i++) {
                    if((int)max.get(i) > maxtemp) {
                        maxtemp = (int)max.get(i);
                    }
                }
                System.out.println("Максимальное число: " + maxtemp);
                MENU(stack,max);

            case 0:
                System.out.print("Выход из программы");
                System.exit(0);
        }
    }
}
