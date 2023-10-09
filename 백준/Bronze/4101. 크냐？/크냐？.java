import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n1 = Integer.parseInt(st.nextToken());
    int n2 = Integer.parseInt(st.nextToken());
    while (!(n1 == 0 && n2 == 0)) {
      if (n1 > n2) {
        sb.append("Yes\n");
      } else {
        sb.append("No\n");
      }
      st = new StringTokenizer(br.readLine());
      n1 = Integer.parseInt(st.nextToken());
      n2 = Integer.parseInt(st.nextToken());
    }
    System.out.println(sb.toString());
  }
}
