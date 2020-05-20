//Tukalevsky var18 ex2

package com.company;

import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    public static void main(String args[]){

        try{
            Scanner in = new Scanner(System.in);
            int n, add;
            System.out.print("Введите количество значений N: ");
            n = in.nextInt();
            while (n <= 0) {
                System.out.print("Введите целое положительное число: ");
                n = in.nextInt();
            }
            System.out.print("Введите количество значений Add: ");
            add = in.nextInt();
            while (add <= 0) {
                System.out.print("Введите целое положительное число: ");
                add = in.nextInt();
            }

            LinkedList list = new LinkedList<Integer>();
            System.out.print("Введите значения N: ");

            for(int i = 0; i < n; i++){
                list.add(in.nextInt());
            }

            System.out.print("Введите значения Add: ");
            for(int i = 0; i < add; i++) {
                list.add(in.nextInt());
            }

            list.sort(null);
            System.out.print("Отсортированные: ");
            for(int i = 0; i < n + add; i++){
                System.out.print(list.get(i) + " ");
            }
        }
        catch(Exception e){
            System.out.println("Введите целое число");
            return;
        }
    }
}
