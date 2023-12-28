import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();  // 기존 진법
        int B = sc.nextInt();  // 변환할 진법
        int m = sc.nextInt();  // A진법으로 표현된 수의 자릿수

        int decimal = 0;  // 10진수로 변환한 값
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            decimal += num * Math.pow(A, m - i - 1);
        }

        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(decimal % B);
            decimal /= B;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
