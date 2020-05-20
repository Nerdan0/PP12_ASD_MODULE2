// ПП-12
// Черниш
// Варіант 3 (19)

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {


        try {


            Scanner sc = new Scanner(System.in);

            doubleLinkedList mainList = new doubleLinkedList();

            System.out.println("Enter N:");

            int N = sc.nextInt();

            System.out.println("Enter N values:");

            for (int i = 0; i<N;i++)
            {

                mainList.addNode(sc.nextInt());

            }

            mainList.printlist();

            System.out.println();

            System.out.println("Enter Add:");

            N = sc.nextInt();

            System.out.println("Enter Add values:");

            for (int i = 0; i<N;i++)
            {

                mainList.addNode(sc.nextInt());

            }

            mainList.sortList();

            System.out.println("Sorted list: ");

            mainList.printlist();



        } catch (java.util.InputMismatchException e) {

            System.out.println("Please, enter valid number");

        }
    }

    public static class doubleLinkedList
    {

        listNode root;

        class listNode
        {

            int value;
            listNode prevNode;
            listNode nextNode;

            listNode(int value)
            {

                this.value = value;

            }

        }


        void addNode(int value)
        {

            listNode tmpNode = new listNode(value);
            listNode current = root;
            tmpNode.nextNode = null;

            if (root == null) {
                tmpNode.prevNode = null;
                root = tmpNode;
                return;
            }

            while (current.nextNode != null)
            {

                current = current.nextNode;

            }

            current.nextNode = tmpNode;
            tmpNode.prevNode = current;

        }

        public void printlist()
        {
            listNode current = root;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.nextNode;
            }
        }

        public void sortList() {
            listNode current = root, index, tmpNode;
            int tmp;

            if(root == null) {
                return;
            }

            while (current.nextNode!=null)
            {

                index = current.nextNode;
                tmpNode = current;

                while (index != null)
                {

                    if (tmpNode.value>index.value)
                    {

                        tmpNode = index;

                    }

                    index = index.nextNode;

                }

                tmp = current.value;
                current.value = tmpNode.value;
                tmpNode.value=tmp;

                current = current.nextNode;

            }

        }

    }

}

