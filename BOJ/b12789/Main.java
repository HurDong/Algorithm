import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();

    Stack<Integer> tempLine = new Stack<>();

    boolean ans = true;

    int n = Integer.parseInt(st.nextToken());

    Queue<Integer> lines = new LinkedList<>();

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      lines.add(Integer.parseInt(st.nextToken()));
    }

    int idx = 1;

    while (idx <= n) {
      // System.out.println("===" + idx + "===");
      // System.out.println(lines);
      // System.out.println(tempLine+"\n");
      // 현재 들어가야할 사람이 lines에 존재하는 경우
      if (lines.contains(idx)) {
        while (lines.contains(idx)) {
          tempLine.push(lines.poll());
        }
        tempLine.pop();
      }
      // 현재 들어가야할 사람이 tempLine에 존재하는 경우
      else if (tempLine.contains(idx)) {
        // 그사람이 tempLine top에 위치할 경우
        if (tempLine.peek() == idx) {
          tempLine.pop();
        }
        // top이 아닐 경우 ans는 false
        else {
          ans = false;
          break;
        }
      }
      // 현재 들어가야할 사람이 tempLine,lines 어디에도 없는 경우
      else {
        ans = false;
        break;
      }
      idx++;
    }

    if (ans) {
      sb.append("Nice");
    } else {
      sb.append("Sad");
    }
    System.out.println(sb.toString());
  }
}
