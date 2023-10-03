import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if (com.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            } else if (com.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll() + "\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (com.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if (com.equals("empty")) {
                if (!queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append("1\n");
                }
            } else if (com.equals("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek() + "\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (com.equals("back")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.getLast() + "\n");
                } else {
                    sb.append("-1\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
