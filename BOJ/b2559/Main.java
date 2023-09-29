package b2559;

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
    int k = Integer.parseInt(st.nextToken());
    int[] num = new int[n];
    int[] sum = new int[n - k + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < n - k + 1; i++) {
      for (int j = 0; j < k; j++) {
        sum[i] += num[i + j];
      }
    }
    Arrays.sort(sum);
    System.out.println(sum[n - k]);
  }
}
