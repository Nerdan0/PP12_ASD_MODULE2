//ПП-12
//Шкаленко
//1 вариант (22)

package com.company;

import java.util.Scanner;

class Stack{
    Stack next;
    int value;

    public Stack(int value){
        this.value = value;
    }

}

class workingStack{

    Stack tail = null;
    static int n = 100;
    int globalI=0;
    int gmas[] = new int[n];
    public void add(int value){
        Stack newEl = new Stack(value);
        if (tail == null){
            tail = newEl;
        }
        else {

            newEl.next = tail;
            tail = newEl;
        }
    }


    public void delete(int value){
        int mas[] = new int[n], i=0;
        Stack temp = tail;
        while (temp!=null){

            mas[i] = temp.value;
            i++;
            tail = temp.next;
            if (temp.value==value){
                for (int j=i-2; j>=0; j--){
                    add(mas[j]);
                }
                break;
            }
            temp = temp.next;
        }
    }

    public void findMax(){
        int Max = 0;
        Stack temp = tail;
        while (temp!=null){
            if (temp.value > Max ){
                Max = temp.value;
                gmas[globalI] = Max;
            }
            temp = temp.next;

        }
        globalI++;
        for (int i = 0;i<globalI ;i++){
            System.out.print(gmas[i]+" ");
        }
        System.out.println();

    }



    public void print(){
        Stack temp = tail;
        while (temp!=null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}

public class Main {

    public static void main(String[] args) {
        workingStack s = new workingStack();
        System.out.println("Укажите количество операций со стеком");
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();

        for (int i = 0; i<n; i++){
            System.out.println("Введите 1, 2 или 3");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1:
                    System.out.println("Введите число, которое хотите добавить");
                    int b = sc.nextInt();
                    s.add(b);
                    break;
                case 2:
                    System.out.println("Введите число, которое хотите удалить");
                    int c = sc.nextInt();
                    s.delete(c);
                    break;
                case 3:
                    System.out.print("Максимальные числа в списке на данный момент: ");
                    s.findMax();
                    break;
            }

        }
        System.out.print("Конечный стек: ");
        s.print();



    }
}
