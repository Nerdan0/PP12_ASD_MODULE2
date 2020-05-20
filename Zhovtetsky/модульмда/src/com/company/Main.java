package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sumKu, ku, value;
        sumKu = in.nextInt();
        Stack stack = new Stack();
        for (int i = 0; i < sumKu; i++) {
            System.out.println("печать");
            ku = in.nextInt();
            switch (ku) {
                case 1:
                    value = in.nextInt();
                    stack.add(value);
                    stack.print();
                    break;
                case 2:
                    stack.remove();
                    stack.print();
                    break;
                case 3:
                    System.out.println(stack.getBiggest());
                    break;
                default:
                    System.out.println("мда... думай лучше");
                    break;
            }
        }
    }
}

