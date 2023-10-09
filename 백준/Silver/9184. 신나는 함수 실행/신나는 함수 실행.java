import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[][][] dp = new int[21][21][21];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    while (!(a == -1 && b == -1 && c == -1)) {
      sb.append("w(" + a + ", " + b + ", " + c + ") = " + fun(a, b, c) + "\n");
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
    }
    System.out.println(sb.toString());
  }

  private static int fun(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0) {
      return 1;
    } else if (a > 20 || b > 20 || c > 20) {
      return fun(20, 20, 20);
    }
    if (dp[a][b][c] != 0) return dp[a][b][c];
    if (a < b && b < c) {
      dp[a][b][c] = fun(a, b, c - 1) + fun(a, b - 1, c - 1) - fun(a, b - 1, c);
    } else {
      dp[a][b][c] =
        fun(a - 1, b, c) +
        fun(a - 1, b - 1, c) +
        fun(a - 1, b, c - 1) -
        fun(a - 1, b - 1, c - 1);
    }
    return dp[a][b][c];
  }
}
