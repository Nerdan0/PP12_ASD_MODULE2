//ПП-12
//Чернях  Анастасія
//Варіант 4(20)
import java.util.*;
class Node {
    public boolean isNull;
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
    public Node(){
        isNull = true;
    }

}
public class BinaryTree {
    Node root;
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    private Node Recursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = Recursive(current.left, value);
        } else if (value > current.value) {
            current.right = Recursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }
    public void add(int value) {
        root = Recursive(root, value);
    }

    int findLCA(int n1, int n2) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    private int findLCAInternal(Node root, int n1, int n2) {
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 присутній" : "n1 відсутній");
            System.out.println((path2.size() > 0) ? "n2 присутній" : "n2 відсутній");
            return -1;
        }
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i - 1);
    }

    private boolean findPath(Node root, int n, List<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.value);

        if (root.value == n) {
            return true;
        }
        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
        path.remove(path.size() - 1);

        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("Введіть кількість вузлів:");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for(int i=0; i<N; i++){
            tree.add(i);
        }
        System.out.println("Введіть два вузла n1 та n2:");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        System.out.println("Найменьший спільний предок двух вузлів:" + tree.findLCA(n1, n2));
    }
}

