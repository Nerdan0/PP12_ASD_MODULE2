//ПП-12
//Гаврилян
//1 вариант (3)
package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    static class Stack {
        int size = 0;
        ArrayList<Integer> data = new ArrayList<Integer>();

        void push(int value) {
            data.add(value);
            size++;
        }

        void show() {
            System.out.println(data.toString());
        }

        int pop() {
            --size;
            int s = data.get(size);
            data.remove(size);
            return s;
        }

        int findMax() {
            int max = data.get(0);
            for (int a : data) {
                if (a > max) {
                    max = a;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("enter N (number of operations) ");
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            Stack stack = new Stack();
            for (int i = 1; i <= N; i++) {
                System.out.println("choose " + i + " operation (1, 2 or 3)");
                int num = in.nextInt();

                switch(num){
                    case 1:
                    System.out.println("enter number u want to add");
                    int a = in.nextInt();
                    stack.push(a);
                    stack.show();
                    break;
                    case 2:
                        stack.pop();
                        System.out.println("last number was deleted");
                        stack.show();
                        break;
                    case 3:
                    System.out.println("Max element = " + stack.findMax());
                    stack.show();
                    break;
                    default:
                        System.out.println("incorrect input");
                        break;
                }
            }
            System.out.println("Max element = " + stack.findMax());
        }catch(Exception e){
            System.out.println("error "+e);
        }
    }
}



