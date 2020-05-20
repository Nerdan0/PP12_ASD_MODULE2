// variant 4 Krekoten Nikita(8)

import java.util.Scanner;

class Ex2{
    public void solution(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of 1 stack ");
        int size1 = scanner.nextInt();
        System.out.println("Enter size of 2 stack ");
        int size2 = scanner.nextInt();
        System.out.println("Enter size of 3 stack ");
        int size3 = scanner.nextInt();

        int total1;
        int total2;
        int total3;

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();

        System.out.println("Fill 1 stack");
        total1 = fillStackWithSum(stack1, size1);

        System.out.println("Fill 2 stack");
        total2 = fillStackWithSum(stack2, size2);

        System.out.println("Fill 3 stack");
        total3 = fillStackWithSum(stack3, size3);

        System.out.println("Stack 1: ");
        stack1.display();

        System.out.println("Stack 2: ");
        stack2.display();

        System.out.println("Stack 3: ");
        stack3.display();

        System.out.println("Total 1: " + total1 + " Total 2: " + total2 + " Total 3: " + total3);
        int value;

        while(!((total1==total2)&&(total2==total3)&&(total1==total3))){
            if(total1>=total2 && total1>=total3){
                value = stack1.top.data;
                total1 -= value;
                stack1.pop();
            }else if(total2 >=total1 && total2>=total3){
                value = stack2.top.data;
                total2 -= value;
                stack2.pop();
            }else{
                value = stack3.top.data;
                total3 -= value;
                stack3.pop();
            }
        }

        System.out.println("Current total: " + total1);

        System.out.println("Stack 1: ");
        stack1.display();

        System.out.println("Stack 2: ");
        stack2.display();

        System.out.println("Stack 3: ");
        stack3.display();

    }

    public int fillStackWithSum( Stack stack, int size){
        int total = 0;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i < size;i++){
            System.out.println("Enter " + (i + 1) + " value ");
            int value = scanner.nextInt();
            stack.push(value);
            total += value;
        }
        return total;
    }

    class Stack{
        Node top;

        class Node{
            int data;
            Node link;

            Node(int d){
                data = d;
                link = null;
            }
        }

        public void push(int data){
            Node temp = new Node(data);
            if (temp == null) {
                System.out.print("\nHeap Overflow");
                return;
            }

            temp.link = top;

            top = temp;
        }

        public boolean isEmpty(){
            return this.top == null;
        }

        public void pop() {
            if (top == null) {
                System.out.println("Stack is empty");
                return;
            }
            top = (top).link;
        }

        public void display() {
            if (this.isEmpty()){
                System.out.println("Stack is empty");
            }
            else {
                Node temp = top;
                while (temp != null) {
                    System.out.print(temp.data + ", ");
                    temp = temp.link;
                }
            }
            System.out.println();
        }
    }
}

