package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер 1 стека ");
        int size1 = scanner.nextInt();
        System.out.println("Введите размер 2 стека");
        int size2 = scanner.nextInt();
        System.out.println("Введите размер 3 стека ");
        int size3 = scanner.nextInt();

        int ku1;
        int kuku;
        int kukusi;

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();

        System.out.println("Заполнить 1 стек");
        ku1 = fillStackWithSum(stack1, size1);
        System.out.println("Заполнить 2 стек");
        kuku = fillStackWithSum(stack2, size2);
        System.out.println("Заполнить 3 стек");
        kukusi = fillStackWithSum(stack3, size3);

        System.out.println("Стек 1: ");
        stack1.display();
        System.out.println("Стек 2: ");
        stack2.display();
        System.out.println("Стек 3: ");
        stack3.display();

        System.out.println("Total 1: " + ku1 + " Total 2: " + kuku + " Total 3: " + kukusi);
        int value;
        while(!((ku1==kuku)&&(kuku==kukusi)&&(ku1==kukusi))){
            if(ku1>=kuku && ku1>=kukusi){
                value = stack1.top.data;
                ku1 -= value;
                stack1.pop();
            }else if(kuku >=ku1 && kuku>=kukusi){
                value = stack2.top.data;
                kuku -= value;
                stack2.pop();
            }else{
                value = stack3.top.data;
                kukusi -= value;
                stack3.pop();
            }
        }

        System.out.println("Текущий итог: " + ku1);

        System.out.println("Стек 1: ");
        stack1.display();
        System.out.println("Стек 2: ");
        stack2.display();
        System.out.println("Стек 3: ");
        stack3.display();

    }

    public static int fillStackWithSum(Stack stack, int size){
        int total = 0;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i < size;i++){
            System.out.println("Введите " + (i + 1) + " значение ");
            int value = scanner.nextInt();
            stack.push(value);
            total += value;
        }
        return total;
    }

    static class Stack{
        Node top;

        class Node{
            int data;
            Node link;

            Node(int d){
                data = d;
                link = null;
            }
        }

        public void push(int data){
            Node temp = new Node(data);
            if (temp == null) {
                System.out.print("\nПереполнение");
                return;
            }

            temp.link = top;

            top = temp;
        }

        public boolean isEmpty(){
            return this.top == null;
        }

        public void pop() {
            if (top == null) {
                System.out.println("Стек пуст");
                return;
            }
            top = (top).link;
        }

        public void display() {
            if (this.isEmpty()){
                System.out.println("Стек пуст");
            }
            else {
                Node temp = top;
                while (temp != null) {
                    System.out.print(temp.data + ", ");
                    temp = temp.link;
                }
            }
            System.out.println();
        }
    }
    }
