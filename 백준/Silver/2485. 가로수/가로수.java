import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] dif;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int[] tree = new int[n];

    dif = new int[n - 1];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      tree[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n - 1; i++) {
      dif[i] = tree[i + 1] - tree[i];
    }

    int ans = 0;
    int gcd = getGCD();
    for (int i = 0; i < n - 1; i++) {
      ans = ans + (dif[i] / gcd - 1);
    }
    System.out.println(ans);
  }

  private static int getGCD() {
    int result = dif[0];
    for (int i = 1; i < dif.length; i++) {
      result = findGCD(result, dif[i]);
    }
    return result;
  }

  private static int findGCD(int result, int target) {
    while (target != 0) {
      int temp = target;
      target = result % target;
      result = temp;
    }
    return result;
  }
}
