package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree Tree = new Tree();
        Tree.create();
        Scanner input = new Scanner(System.in);
        int n1, n2;
        System.out.println("Введіть n1 та n2:");
        n1 = input.nextInt();
        n2 = input.nextInt();
        Tree.find_parent(n1, n2);
    }
}