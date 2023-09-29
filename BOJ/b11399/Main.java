package b11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] line = new int[n];
    int[] time = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      line[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(line);
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum + line[i];
      time[i] = sum;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = ans + time[i];
    }
    System.out.println(ans);
    // 1 3 6 9 13
  }
}
