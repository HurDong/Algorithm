package b24511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    int[][] qs = new int[n][2]; // [][0] 에 queue인지 stack인지 저장 [][1]에 배열값 저장
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      qs[i][0] = Integer.parseInt(st.nextToken());
      // 0이면 큐 -> 원래있던 애 pop
      // 1이면 스택 -> 들어오는 애 pop
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      qs[i][1] = Integer.parseInt(st.nextToken());
    }
    Stack<Integer> ds = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (qs[i][0] == 0) {
        ds.push(qs[i][1]);
      }
    }
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int[] target = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      target[i] = Integer.parseInt(st.nextToken());
    }
    int idx = 0;
    for (int i = 0; i < m; i++) {
      if (ds.isEmpty()) {
        sb.append(target[idx++] + " ");
      } else {
        sb.append(ds.pop()+" ");
      }
    }
    System.out.println(sb.toString());
  }
}