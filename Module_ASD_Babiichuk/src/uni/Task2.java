package uni; 

import java.util.Scanner;

//Задача 2. Створити двозв’язний список цілочисельних значень. На
//початку ввести кількість значень N, що будуть прийняті в список та кількість
//значень Add, що будуть до нього додані.
//Ввести необхідні значення у список, після останнього список має
//виводитись автоматично. Після цього додати значення до списку, відсортувати
//та вивести його

class ListElement {
    int value;
    ListElement next;
    ListElement previous;

    ListElement() {
    }

    ListElement(int value) {
        this.value = value;
    }
}

class newList {

    ListElement head = null, tail = null;

    public void create(int startAmount) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < startAmount; i++) {
            System.out.println("Enter " + (i + 1) + " element");
            ListElement temp = new ListElement(sc.nextInt());

            if (tail == null) {
                tail = temp;
                head = temp;
            } else {
                tail.next = temp;
                temp.previous = tail;
                tail = temp;
            }
        }
    }

    public void add(int startAmount) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < startAmount; i++) {
            System.out.println("Enter element to add :");
            ListElement temp = new ListElement(sc.nextInt());
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        }

    }

    public void show() {
        ListElement temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;

        }
        System.out.println();
    }


    public void sort(int startAmount, int addAmount) {

        int size = startAmount + addAmount;

        for (int i = 0; i < size - 1; i++) {
            ListElement curr = head;
            while (curr.next != null) {
                if (curr.value > curr.next.value) {
                    int tempValue = curr.value;
                    curr.value = curr.next.value;
                    curr.next.value = tempValue;
                }
                curr = curr.next;
            }
        }
    }

}

public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        newList List = new newList();
        System.out.println("Enter N, Add :");
        int startAmount = sc.nextInt();
        int addAmount = sc.nextInt();
        List.create(startAmount);
        List.show();
        List.add(addAmount);
        List.sort(startAmount, addAmount);
        System.out.println("Sorted List :");
        List.show();

    }
}
