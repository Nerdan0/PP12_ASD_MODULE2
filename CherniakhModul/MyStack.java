import java.util.Scanner;
import java.util.Stack;
    public class MyStack {
        public static void main(String[] args) {
            int min = 1000;
            int stackSize1 = 0;
            int stackSize2 = 0;
            int stackSize3 = 0;
            Scanner input = new Scanner(System.in);
            System.out.println("Введіть розмір N1");
            int N1 = input.nextInt();
            System.out.println("Введіть розмір N2");
            int N2 = input.nextInt();
            System.out.println("Введіть розмір N3");
            int N3 = input.nextInt();
            Stack stack1 = new Stack<Integer>();
            Stack stack2 = new Stack<Integer>();
            Stack stack3 = new Stack<Integer>();
            System.out.println("Введіть значення N1: ");
            for (int i = 0; i < N1; i++) {
                int number = input.nextInt();
                stack1.push(number);
                stackSize1 = +number;

            }
            System.out.println("Введіть значення N2: ");
            for (int i = 0; i < N2; i++) {
                int number = input.nextInt();
                stack2.push(number);
                stackSize2 = +number;
            }
            System.out.println("Введіть значення N3: ");
            for (int i = 0; i < N3; i++) {
                int number = input.nextInt();
                stack3.push(number);
                stackSize3 = +number;
            }
            if (min > stackSize1 && min > stackSize2 && min > stackSize3) {
                min = stackSize1;
                min = stackSize2;
                min = stackSize3;
            }
            do {
                int number = (int) stack1.pop();
                stackSize1 -= number;
                if (stackSize1 < min) {
                    min = stackSize1;
                }
            } while (stackSize1 > min);

            do {
                int number = (int) stack2.pop();
                stackSize2 -= number;
                if (stackSize2 < min) {
                    min = stackSize2;
                }
            } while (stackSize2 > min);

            do {
                int number = (int) stack3.pop();
                stackSize3 -= number;
                if (stackSize3 < min) {
                    min = stackSize3;
                }
            } while (stackSize3 > min);

            if (min!=0 && stackSize1 == stackSize2 && stackSize2 == stackSize3) {
                System.out.println("Так, можна");
                System.out.println("Max=" + min);
            }
            if (min <= 0) {
                System.out.println("Ні, не можна");


            }
        }
    }
