package b1991;

import java.util.Scanner;

class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
    }
}

public class Main {
    static Node[] tree = new Node[26];

    public static void preOrder(Node node) {
        System.out.print(node.data);
        if (node.left != null)
            preOrder(node.left);
        if (node.right != null)
            preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node.left != null)
            inOrder(node.left);
        System.out.print(node.data);
        if (node.right != null)
            inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node.left != null)
            postOrder(node.left);
        if (node.right != null)
            postOrder(node.right);
        System.out.print(node.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            char data = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);

            if (tree[data - 'A'] == null) {
                tree[data - 'A'] = new Node(data);
            }
            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[data - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[data - 'A'].right = tree[right - 'A'];
            }
        }

        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
    }
}
