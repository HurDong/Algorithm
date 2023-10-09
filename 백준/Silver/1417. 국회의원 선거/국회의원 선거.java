import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] cand = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      cand[i] = Integer.parseInt(st.nextToken());
    }
    int count = 0;
    while (true) {
      int max = Integer.MIN_VALUE;
      int idx = -1;
      for (int i = 0; i < n; i++) {
        if (cand[i] >= max) {
          max = cand[i];
          idx = i;
        }
      }
      if (idx == 0) {
        break;
      } else {
        cand[idx]--;
        cand[0]++;
        count++;
      }
    }
    System.out.println(count);
  }
}
