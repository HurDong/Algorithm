package b15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    visited = new boolean[n + 1];
    ans = new int[m + 1];
    seq(0);
    System.out.println(sb.toString());
  }

  private static void seq(int len) {
    // visited가 true면 if문 발동 x , false면 if문 발동하면서 true로 만들어주고 if문 끝날 때 false로 다시 set
    if (len == m) {
      for (int i = 1; i <= m; i++) {
        sb.append(ans[i] + " ");
      }
      sb.append("\n");
      return;
    } else {
      for (int i = 1; i <= n; i++) {
        // if (!visited[i]) {
        // visited[i] = true;
        ans[len + 1] = i;
        if (ans[len] <= ans[len + 1]) {
          seq(len + 1);
        }
        // visited[i] = false;
        // }
      }
    }
  }
}
