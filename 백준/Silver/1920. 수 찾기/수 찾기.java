import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int[] target = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      target[i] = Integer.parseInt(st.nextToken());
      if (Arrays.binarySearch(arr, target[i]) >= 0) sb.append("1\n"); else {
        sb.append("0\n");
      }
    }
    System.out.println(sb.toString());
  }
}
