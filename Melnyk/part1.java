import java.util.Scanner;
import java.util.Stack;

public class part1 {
        public static void main(String[] args) {
            Stack<Integer> myStack = new Stack<>();
            Stack<Integer> maxValues = new Stack<>();

            try {
                int i;
                int p;
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Введіть кількість операцій");
                    int o = sc.nextInt();

                    for (i = 0; i < o; i++) {
                        System.out.println("\n1. Додати число в стек" +
                                "\n2. Видалити число з стеку" +
                                "\n3. Вивести найбільше значення" +
                                "\n4. Вихід");
                        int n = sc.nextInt();
                        switch (n) {
                            case 1:
                                Scanner sc1 = new Scanner(System.in);
                                System.out.println("Введіть число яке додаємо в стек:");
                                int x = sc1.nextInt();
                                myStack.push(x);
                                break;
                            case 2:
                                myStack.pop();
                                break;
                            case 3:
                                Integer max = -1500000;
                                for (Integer element : myStack) {
                                    if (element > max) max = element;
                                }
                                System.out.println(max);
                                maxValues.add(max);
                                break;
                            case 4:
                                System.exit(0);
                        }
                    }
                        System.out.println("Стек :");
                        System.out.println(myStack);

                         System.out.println("Всі максимальні значення які були виведені :");
                        for (Integer value : maxValues) {
                            System.out.println(value);
                        }



            } catch (Exception e){
                System.out.println("Ви ввели неправильний тип даних");
            }
        }
    }
