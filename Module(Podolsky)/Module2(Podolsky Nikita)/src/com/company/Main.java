package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int N1, N2, N3;
        Scanner Scaner = new Scanner(System.in);
        Stek Stek1, Stek2, Stek3;
        Stek1 = new Stek();
        Stek2 = new Stek();
        Stek3 = new Stek();
        System.out.print("Введіть N1: ");
        N1 = Scaner.nextInt();
        System.out.print("Введіть N2: ");
        N2 = Scaner.nextInt();
        System.out.print("Введіть N3: ");
        N3 = Scaner.nextInt();
        int new_elem;
        System.out.println("Введіть вагу кожного елементу стеку 1:");
        for (int i = 0; i < N1; i++)
        {
            new_elem = Scaner.nextInt();
            Stek1.add(Stek1, new_elem);
        }
        System.out.println("Введіть вагу кожного елементу стеку 2:");
        for (int i = 0; i < N2; i++)
        {
            new_elem = Scaner.nextInt();
            Stek2.add(Stek2, new_elem);
        }
        System.out.println("Введіть вагу кожного елементу стеку 3:");
        for (int i = 0; i < N3; i++)
        {
            new_elem = Scaner.nextInt();
            Stek3.add(Stek3, new_elem);
        }
        System.out.println("Стек 1 до вирівнювання:");
        Stek1.display(Stek1);
        System.out.println("Стек 2 до вирівнювання:");
        Stek2.display(Stek2);
        System.out.println("Стек 3 до вирівнювання:");
        Stek3.display(Stek3);
        while((Stek1.sum(Stek1, N1) != Stek2.sum(Stek2, N2))||(Stek2.sum(Stek2, N2) != Stek3.sum(Stek3, N3)))
        {
            if((Stek1.sum(Stek1, N1) >= Stek2.sum(Stek2, N2))&&(Stek1.sum(Stek1, N1) >= Stek3.sum(Stek3, N3)))
            {
                Stek1.delete(Stek1, N1);
                N1--;
            }
            else if((Stek2.sum(Stek2, N2) >= Stek1.sum(Stek1, N1))&&(Stek2.sum(Stek2, N2) >= Stek3.sum(Stek3, N3)))
            {
                Stek2.delete(Stek2, N2);
                N2--;
            }
            else
            {
                Stek3.delete(Stek3, N3);
                N3--;
            }
        }
        System.out.println("Стек 1 після вирівнювання:");
        Stek1.display(Stek1);
        System.out.println("Стек 2 після вирівнювання:");
        Stek2.display(Stek2);
        System.out.println("Стек 3 після вирівнювання:");
        Stek3.display(Stek3);
        System.out.print("Максимальна спільна вага при якій стеки дорівнюють один одному: ");
        System.out.println(Stek1.sum(Stek1, N1));
    }
}
