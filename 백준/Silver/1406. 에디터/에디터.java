import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int T = Integer.parseInt(br.readLine());
        Stack<Character> lStack = new Stack<>(); // 커서 기준 좌스택
        Stack<Character> rStack = new Stack<>(); // 커서 기준 우스택
        for (int i = 0; i < s.length(); i++) {
            lStack.push(s.charAt(i)); // 커서가 맨 오른쪽에 위치하므로 좌스택으로
        }
        while (T-- > 0) {
            String ins = br.readLine();
            if (ins.equals("L")) {
                // 커서 좌로 이동 -> 우스택 추가
                if (!lStack.isEmpty()) {
                    rStack.push(lStack.pop());
                }
            } else if (ins.equals("D")) {
                if (!rStack.isEmpty()) {
                    lStack.push(rStack.pop());
                }
            } else if (ins.equals("B")) {
                if (!lStack.isEmpty()) {
                    lStack.pop();
                }
            } else if (ins.startsWith("P")) {
                char c = ins.charAt(2);
                lStack.push(c);
            }
        }
        while (!lStack.isEmpty()) {
            rStack.push(lStack.pop());
        }
        while (!rStack.isEmpty()) {
            sb.append(rStack.pop());
        }
        System.out.println(sb.toString());
    }
}
