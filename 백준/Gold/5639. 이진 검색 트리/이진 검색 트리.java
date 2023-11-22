import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        void insert(int value) {
            if (value < this.data) {
                // 좌측 노드로
                if (this.left == null) {
                    this.left = new Node(value);
                } else {
                    // 이미 차있을 경우 한번 더 재귀
                    this.left.insert(value);
                }
            } else {
                // 우측 노드로
                if (this.right == null) {
                    this.right = new Node(value);
                } else {
                    this.right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String input;
        Node root = new Node(sc.nextInt());

        while (sc.hasNextInt()) {
            root.insert(sc.nextInt());
        }
        printPostOrder(root); // 후위 순회
    }

    private static void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.println(node.data);
        }
    }
}
