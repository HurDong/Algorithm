package b2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static char[][] star;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    // 9개의 단위체중 5번째 단위체는 blank로 처리하기
    int n = Integer.parseInt(st.nextToken());
    star = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        star[i][j] = '*';
      }
    }
    draw(n, 0, 0, true);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(star[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  private static void draw(int n, int x, int y, boolean blank) {
    // blank가 false일 경우 해당 범위를 빈칸으로 만든다.
    if (blank == false) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          star[x + i][y + j] = ' ';
        }
      }
    }
    // n이 1이면 return
    if (n == 1) {
      return;
    }
    // 1. n/3 * n/3 만큼의 범위를 9개로 나눈다.
    // 2. 123 456 789 라고 할떄 5번째 구역을 blank로 만든다.
    // 3. 재귀함수를 이용해 n==1이 될때까지 한다.
    draw(n / 3, x, y, true);
    draw(n / 3, x, y + (n / 3), true);
    draw(n / 3, x, y + (2 * n / 3), true);
    draw(n / 3, x + (n / 3), y, true);
    draw(n / 3, x + (n / 3), y + (n / 3), false);
    draw(n / 3, x + (n / 3), y + (2 * n / 3), true);
    draw(n / 3, x + (2 * n / 3), y, true);
    draw(n / 3, x + (2 * n / 3), y + (n / 3), true);
    draw(n / 3, x + (2 * n / 3), y + (2 * n / 3), true);
  }
}
/*
 * 0 0 1 2 3 4 5 6 7 8
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 */
