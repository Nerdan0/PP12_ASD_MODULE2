package com.company;

import java.util.Scanner;

public class task2 {
    tree root;
    tree current;

    public task2() {
        Scanner scan = new Scanner(System.in);
        int N;
        System.out.println("Введіть кількість вузлів");
        N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("Введіть значення");
            int number = scan.nextInt();
            tree new_tree = new tree(number);
            current = root;
            if (current == null) {
                root = new_tree;
                new_tree.left = null;
                new_tree.right = null;
                new_tree.parent = null;
            } else {
                while (current != null) {
                    if (new_tree.number > current.number) {
                        new_tree.parent = current;
                        current = current.right;
                    } else {
                        new_tree.parent = current;
                        current = current.left;
                    }
                }
                current = new_tree;
                if (new_tree.number > new_tree.parent.number) {
                    new_tree.parent.right = new_tree;
                } else {
                    new_tree.parent.left = new_tree;
                }
                new_tree.right = null;
                new_tree.left = null;
            }
        }

        System.out.println("Введіть n1 та n2");
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        tree pointer_n1, pointer_n2;
        pointer_n1 = find(n1);
        pointer_n2 = find(n2);

        pointer_n1 = pointer_n1.parent;
        pointer_n2 = pointer_n2.parent;
        int min = 99999;
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
        if(min == 99999) {
            System.out.println("Найменший батько не знайдений");
        }
        else {
            System.out.println("Найменший батько: " + min);
        }
    }

    public tree find(int key){
        current = root;
        for(;;){
            if(current == null)
            {
                return null;
            }
            else
            {
                if(current.number == key)
                {
                    return current;
                }
                else if(key > current.number)
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
}
