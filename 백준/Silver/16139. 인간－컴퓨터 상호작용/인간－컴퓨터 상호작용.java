import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static String s;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    s = st.nextToken();
    st = new StringTokenizer(br.readLine());
    int q = Integer.parseInt(st.nextToken());
    char alphabet;
    int l;
    int r;
    int[][] sum = new int[s.length()][26];
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < 26; j++) {
        sum[i][j] = 0;
      }
    }
    sum[0][s.charAt(0) - 'a']++;
    for (int i = 1; i < s.length(); i++) {
      for (int j = 0; j < 26; j++) {
        sum[i][j] = sum[i - 1][j];
      }
      sum[i][s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      alphabet = st.nextToken().charAt(0);
      l = Integer.parseInt(st.nextToken());
      r = Integer.parseInt(st.nextToken());
      if (l == 0) {
        sb.append(sum[r][alphabet - 'a'] + "\n");
      } else {
        sb.append(sum[r][alphabet - 'a'] - sum[l - 1][alphabet - 'a'] + "\n");
      }
    }
    System.out.println(sb.toString());
  }
}
