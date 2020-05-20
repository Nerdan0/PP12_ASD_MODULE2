package com.company;
//1 variant
//2 task
import java.util.Scanner;

class Task2 {
    Node node;

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    public boolean find(int value) {
        Node current = node;
        while (current != null) {
            if (current.data == value) {
                return true;
            } else if (current.data > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }


    public void add(int value) {
        Node newNode = new Node(value);
        if (node == null) {
            node = newNode;
            return;
        }
        Node current = node;
        Node parent;
        while (true) {
            parent = current;
            if (value < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }


    public void min(){
        if (node != null){
            Node current_max = node;
            Node current_min = node;

            if (node.left == null){
                System.out.println("min = " + node.data);

                while (current_max.right != null) {
                    current_max = current_max.right;
                }
            }
            else if (node.right == null){
                while (current_min.left != null) {
                    current_min = current_min.left;
                    if (current_min.left == null) {
                        System.out.println("min = " + current_min.data);
                    }
                }
            }
            else {
                while (current_max.right != null) {
                    current_max = current_max.right;
                }

                while (current_min.left != null) {
                    current_min = current_min.left;
                    if (current_min.left == null) {
                        System.out.println("min = " + current_min.data);
                    }
                }
            }
        }
    }

    public void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }
    }


    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            Task2 tree = new Task2();
            System.out.print("Enter number of nodes: ");
            int N = in.nextInt();
            int[] a = new int[N];

            System.out.println("input values: ");

            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
                tree.add(a[i]);
            }
            tree.print(tree.node);
            System.out.print("\n");

            System.out.println("Enter n1: ");
            int n1 = in.nextInt();
            boolean check = tree.find(n1);
            if (!check) {
                System.out.println("There is no node " + n1);
            }
            System.out.println("Enter n2: ");
            int n2 = in.nextInt();
            boolean check2 = tree.find(n2);
            if (!check2) {
                System.out.println("There is no node " + n2);
            }
            System.out.print("\n");

            tree.min();
        } catch (Exception e){
            System.out.println("error " +e);
        }
    }}