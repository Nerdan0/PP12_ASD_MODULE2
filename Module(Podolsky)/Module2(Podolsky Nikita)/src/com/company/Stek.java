package com.company;

import java.util.Scanner;

public class Stek {
    int weight;
    Stek next;
    Stek first;
    public void add(Stek Stek, int elem) {
        Scanner input = new Scanner(System.in);
        if (first == null) {
            weight = elem;
            first = this;
        } else {
            Stek nextElem = new Stek();
            nextElem.weight = elem;
            nextElem.next = first;
            first = nextElem;
        }
    }
    public void delete(Stek Stek, int quantity)
    {
        if(first !=null)
            first = first.next;
        else
            System.out.println("Стек пустий");
    }
    public int sum(Stek Stek, int quantity)
    {
        int sum = 0;
        Stek = Stek.first;
        for(int i = 0; i < quantity; i++)
        {
            sum += Stek.weight;
            Stek = Stek.next;
        }
        return sum;
    }
    public void display(Stek Stek)
    {
        Stek = Stek.first;
        int counter = 0;
        while(Stek!=null)
        {
            System.out.println(Stek.weight);
            Stek = Stek.next;
            counter++;
        }
        if(counter == 0)
            System.out.println("Стек пустий");
    }
}
