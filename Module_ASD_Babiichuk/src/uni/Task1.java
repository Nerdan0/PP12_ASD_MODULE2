package uni;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//Задача 1. Створити стек цілочисельних значень. На початку програма
//зчитує три значення (N1, N2, N3 кількість елементів в стеку). В наступних трьох
//рядках вводимо значення ваги кожного елемента стеку.
//Програма повинна визначити чи можна отримати рівне значення в усіх
//трьох стеках видаляючі зайві елементи.
//Результатом роботи має бути виведення максимальної спільної ваги при
//якій стеки будуть дорівнювати одне одному та самі стеки до та після
//вирівнювання.

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter N1, N2 and N3 :");
        int sizeFirst = sc.nextInt(), sizeSecond = sc.nextInt(), sizeThird = sc.nextInt(), valueFirst = 0, valueSecond = 0, valueThird = 0;

        Stack<Integer> stackFirst = new Stack<Integer>();
        ArrayList<Integer> listFirst = new ArrayList<>();
        Stack<Integer> stackSecond = new Stack<Integer>();
        ArrayList<Integer> listSecond = new ArrayList<>();
        Stack<Integer> stackThird = new Stack<Integer>();
        ArrayList<Integer> listThird = new ArrayList<>();

        for (int i = 0; i < sizeFirst; i++) {
            System.out.println("Enter element to add to first stack :");
            int temp = sc.nextInt();
            listFirst.add(temp);
            stackFirst.push(temp);
            valueFirst += temp;
        }

        for (int i = 0; i < sizeSecond; i++) {
            System.out.println("Enter element to add to second stack :");
            int temp = sc.nextInt();
            listSecond.add(temp);
            stackSecond.push(temp);
            valueSecond += temp;
        }

        for (int i = 0; i < sizeThird; i++) {
            System.out.println("Enter element to add to third stack :");
            int temp = sc.nextInt();
            listThird.add(temp);
            stackThird.push(temp);
            valueThird += temp;
        }

        System.out.println("Stacks before equalisation:");
        System.out.println(listFirst + " : value " + valueFirst);
        System.out.println(listSecond + " : value " + valueSecond);
        System.out.println(listThird + " : value " + valueThird);

        int valueMin = Integer.MAX_VALUE;
        while (true) {
            if (valueFirst < valueMin) {
                valueMin = valueFirst;
            } else if (valueSecond < valueMin) {
                valueMin = valueSecond;
            } else if (valueThird < valueMin) {
                valueMin = valueThird;
            }

            while (valueFirst > valueMin) {
                int temp = stackFirst.pop();
                valueFirst -= temp;
                if (valueFirst < valueMin) {
                    valueMin = valueFirst;
                }

            }
            while (valueSecond > valueMin) {
                int temp = stackSecond.pop();
                valueSecond -= temp;
                if (valueSecond < valueMin) {
                    valueMin = valueSecond;
                }

            }
            while (valueThird > valueMin) {
                int temp = stackThird.pop();
                valueThird -= temp;
                if (valueThird < valueMin) {
                    valueMin = valueThird;
                }

            }
            if (valueMin > 0 && valueFirst == valueSecond && valueThird == valueSecond) {
                System.out.println("Result value is " + valueMin + ", stacks :");
                System.out.println(stackFirst);
                System.out.println(stackSecond);
                System.out.println(stackThird);
                break;
            } else if (valueMin <= 0){
                System.out.println("Condition can't be accessed.");
                break;
            }
        }
    }
}
