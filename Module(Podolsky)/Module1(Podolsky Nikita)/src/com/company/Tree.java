package com.company;

import java.util.Scanner;

public class Tree {
        public int number;
        public Tree left;
        public Tree right;
        public Tree parent;
        public Tree root = null;

        public Tree(int number){
            this.number = number;
        }
         public Tree(){
         }
        public void create()
        {
            Tree current;
            Scanner input = new Scanner(System.in);
            int N;
            System.out.println("Введіть кількість вузлів");
            N = input.nextInt();
            for (int i = 0; i < N; i++) {
                System.out.println("Введіть значення");
                int number = input.nextInt();
                Tree New_Tree = new Tree(number);
                current = root;
                if (current == null) {
                    root = New_Tree;
                    New_Tree.left = null;
                    New_Tree.right = null;
                    New_Tree.parent = null;
                } else {
                    while (current != null) {
                        if (New_Tree.number > current.number) {
                            New_Tree.parent = current;
                            current = current.right;
                        } else {
                            New_Tree.parent = current;
                            current = current.left;
                        }
                    }
                    current = New_Tree;
                    if (New_Tree.number > New_Tree.parent.number) {
                        New_Tree.parent.right = New_Tree;
                    } else {
                        New_Tree.parent.left = New_Tree;
                    }
                    New_Tree.right = null;
                    New_Tree.left = null;
                }
            }
        }
    public Tree find(int elem){
        Tree current = root;
        for(;;){
            if(current == null)
            {
                return null;
            }
            else
            {
                if(current.number == elem)
                {
                    return current;
                }
                else if(elem > current.number)
                {
                    current = current.right;
                }
                else
                {
                    current = current.left;
                }
            }
        }
    }
    public void find_parent(int n1, int n2)
    {
        Tree pointer_n1, pointer_n2;
        pointer_n1 = find(n1);
        pointer_n2 = find(n2);

        pointer_n1 = pointer_n1.parent;
        pointer_n2 = pointer_n2.parent;
        int min = 2147483647;
        while(pointer_n1 != null)
        {
            while(pointer_n2 != null)
            {
                if(pointer_n1.number == pointer_n2.number)
                {
                    if(pointer_n1.number < min)
                    {
                        min = pointer_n1.number;
                    }
                }
                pointer_n2 = pointer_n2.parent;
            }
            pointer_n1 = pointer_n1.parent;
        }
        if(min == 2147483647) {
            System.out.println("Найменший батько не знайдений");
        }
        else {
            System.out.println("Найменший батько: " + min);
        }
    }
}


