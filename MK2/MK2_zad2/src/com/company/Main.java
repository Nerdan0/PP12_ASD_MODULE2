//ПП-12
//Шкаленко
//1 вариант (22)

package com.company;

import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int value){
        data=value;
        left=null;
        right=null;
    }
}

class Tree{


    public Tree(int n){
        kol=n;
    }
    int kol;
    public Node root;

    private Node addRec(Node temp, int value) {
        if (temp == null) {
            return new Node(value);
        }
        if (value < temp.data) {
            temp.left = addRec(temp.left, value);
        }
        else if (value > temp.data) {

            temp.right = addRec(temp.right, value);
        }
        else {

            return temp;
        }
        return temp;
    }

    public void add(int value) {
        root = addRec(root, value);
    }


    private void printRec(Node temp) {
        if (temp != null) {

            printRec(temp.left);
            System.out.print(temp.data + " ");
            printRec(temp.right);


        }
    }

    public void print() {

        printRec(root);
        System.out.println();
    }

    int i = 0;
    static int n=100;
    int mas[] = new int[n];

    private int[] findAll(Node temp, int value) {


        if (temp == null) {
            return mas;
        }
        if (value == temp.data) {
            return mas;
        }
        if (value!= temp.data){
            mas[i]=temp.data;
            i++;
        }
        return value < temp.data
                ? findAll(temp.left, value)
                : findAll(temp.right, value);

    }


    public void find(Node temp, int n1, int n2){

        int mas1[] = findAll(temp, n1);


        for (int j = i; j>0; j--){

            mas[j]=0;
        }
        i=0;
        int mas2[] = findAll(temp, n2);

        int min = root.data;
        for (int j = 0; j<n; j++){
            for (int k = 0; k<n; k++){

                if (mas1[j]==mas2[k] && mas1[j]!=0 && mas1[j]<min){
                    min = mas1[j];
                }
            }
        }
        System.out.print(min);
    }




}

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите количество элементов в дереве");
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        Tree tree = new Tree(n);
        System.out.println("Введите значения");
        for(int i = 0; i<n; i++){
            Scanner sc= new Scanner(System.in);
            int a = sc.nextInt();
            tree.add(a);
        }
        System.out.println("Ввеедите н1 и н2");
        int n1 = sc1.nextInt();
        int n2 = sc1.nextInt();

        //tree.print();

        System.out.print("Наименьший общий предок: ");
        tree.find(tree.root, n1, n2);

    }
}
