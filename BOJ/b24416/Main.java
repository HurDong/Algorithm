package b24416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    System.out.println(fivonacci(n) + " " + count);
  }

  private static int fivonacci(int n) {
    int[] fivo = new int[n];
    fivo[0] = 1;
    fivo[1] = 1;
    for (int i = 2; i < n; i++) {
      fivo[i] = fivo[i - 1] + fivo[i - 2];
      count++;
    }
    return fivo[n - 1];
  }
}
