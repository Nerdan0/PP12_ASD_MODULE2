package com.company;

import java.util.Scanner;

public class task1 {
    list first;

    public task1()
    {
        Scanner scan = new Scanner(System.in);
        int N = 0;
        System.out.println("Введіть кількість значень що будуть прийняті");
        N = scan.nextInt();
        int Add = 0;
        System.out.println("Введіть кількість значень що будуть додані");
        Add = scan.nextInt();
        int number = 0;
        for(int i = 0; i < N; i++)
        {
            System.out.println("Ведіть значення");
            number = scan.nextInt();
            list new_list = new list(number);
            if(first == null){
                new_list.next = null;
                first = new_list;
                new_list.prev = null;
            }
            else{
                for(list current = first;;)
                {
                    if(current.next == null){
                        new_list.next = null;
                        current.next = new_list;
                        new_list.prev = current;
                        break;
                    }
                    else{
                        current = current.next;
                    }
                }
            }
        }

        System.out.println("Список");
        list current = first;
        for(int i = 0; i < N; i++)
        {
            current.show();
            current = current.next;
        }
        System.out.println();


        for(int i = 0; i < Add; i++)
        {
            System.out.println("Ведіть значення");
            number = scan.nextInt();
            list new_list = new list(number);
            if(first == null){
                new_list.next = null;
                first = new_list;
                new_list.prev = null;
            }
            else{
                for(current = first;;)
                {
                    if(current.next == null){
                        new_list.next = null;
                        current.next = new_list;
                        new_list.prev = current;
                        break;
                    }
                    else{
                        current = current.next;
                    }
                }
            }
        }

        list current1;
        for(int i = 0; i < (Add+N); i++)
        {
            current = first;
            while(current.next != null) {
                current1 = current.next;
                if (current.number > current1.number) {
                    int swap = current.number;
                    current.number = current1.number;
                    current1.number = swap;
                }
                current = current.next;
            }
        }

        System.out.println("Відсортований список");
        current = first;
        for(int i = 0; i < N+Add; i++)
        {
            current.show();
            current = current.next;
        }
        System.out.println();
    }
}
