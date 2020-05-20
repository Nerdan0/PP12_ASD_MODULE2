package com.company;

public class list {
    int number;
    list prev;
    list next;

    public list(int number) {
        this.number = number;
    }

    public void show(){
        System.out.print(this.number+" ");
    }
}
