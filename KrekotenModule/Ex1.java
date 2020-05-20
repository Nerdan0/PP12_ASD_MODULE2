// variant 4 Krekoten Nikita(8)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Ex1{
    public void solution(){
        BinaryTree tree = new BinaryTree();

        System.out.println("Enter number of nodes");
        int n = 0;

        while (n <= 0){
            n = checkValue();

            if (n <= 0) {
                System.out.println("Input value that higher than 0");
            }
        }

        fillTree(tree, n);
        System.out.print("Nodes from left to right: ");
        tree.showLeftToRight();
        System.out.println();

        System.out.println("Enter 1 node to find lca");
        int n1 = checkValue();

        System.out.println("Enter 2 node to find lca");
        int n2 = checkValue();

        int result = tree.lca(tree.root, n1, n2).value;
        System.out.println("LCA is " + result);
    }

    public static void fillTree(BinaryTree tree, int n){
        int value;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + (i + 1) + " value: ");
            value = checkValue();
            tree.add(value);
        }
    }

    public static int checkValue(){
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()){
            System.out.println("Wrong input, try again");
            scanner.next();
        }

        return scanner.nextInt();
    }
}

class BinaryTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    private Node findRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = findRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = findRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = findRecursive(root, value);
    }

    public void showLeftToRight() {
        if (root == null){
            System.out.println("Binary tree is empty");
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();

            System.out.print(node.value + " ");

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public Node lca(Node node, int n1, int n2)
    {
        if (node == null)
            return null;

        if (node.value > n1 && node.value > n2)
            return lca(node.left, n1, n2);

        if (node.value < n1 && node.value < n2)
            return lca(node.right, n1, n2);

        return node;
    }
}