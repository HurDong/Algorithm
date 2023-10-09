import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] start;
  static int[] link;
  static int[][] stat;
  static boolean[] visited;
  static int n;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    stat = new int[n][n];
    start = new int[n / 2];
    link = new int[n / 2];
    visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        stat[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    bestStat(0, 0);
    System.out.println(min);
  }

  private static void bestStat(int s, int depth) {
    if (depth == (n / 2)) {
      // link 설정 start[idx]를 둘러본다. 맞는게 없다면 이중포문
      int idx = 0;
      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          link[idx++] = i;
        }
      }
      int sumS = 0;
      int sumL = 0;
      for (int i = 0; i < (n / 2); i++) {
        // sumS랑 sumL을 구해야하는데 메서드하나만들기
        sumS = getSum(start);
        sumL = getSum(link);
        if (Math.abs(sumS - sumL) < min) {
          min = Math.abs(sumS - sumL);
        }
      }
      return;
    } else {
      for (int i = s; i < n; i++) {
        start[depth] = i;
        visited[i] = true;
        bestStat(i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }

  private static int getSum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < n / 2; j++) {
        sum += stat[arr[i]][arr[j]];
      }
    }
    return sum;
  }
}
