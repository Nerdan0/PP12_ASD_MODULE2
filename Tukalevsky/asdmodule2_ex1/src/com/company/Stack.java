package com.company;

public class Stack {

    private static class List {
        int element; //элемент стека
        List next; //указатель на след элемент
    }

    List head; //голова стека
    Stack() {
        this.head = null;
    }

    public void add(int x) { //метод добавления в стек
        List temp = new List();
        temp.element = x;
        temp.next = head;
        head = temp;
    }

    public void remove() { //удаление элемента
        head = (head).next;
    }

    public void display() { //вывод
        List temp = head;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
    }
}