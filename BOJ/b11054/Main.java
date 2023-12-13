package b11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] num = new int[n];
    int[] inc = new int[n]; // 인덱스 n을 포함하는 증가하는 배열의 최대 길이 정방향!
    int[] dec = new int[n]; // 인덱스 n을 포함하는 감소하는 배열의 최대 길이 역방향!
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    // 증가 정순
    for (int i = 0; i < n; i++) {
      inc[i] = 1;
      for (int j = 0; j < i; j++) {
        if (num[j] < num[i]) {
          inc[i] = Math.max(inc[j] + 1, inc[i]);
        }
      }
    }
    // 감소 역순
    for (int i = n - 1; i >= 0; i--) {
      dec[i] = 1;
      for (int j = n - 1; j > i; j--) {
        if (num[j] < num[i]) {
          dec[i] = Math.max(dec[j] + 1, dec[i]);
        }
      }
    }
    int answer = 0;
    for (int i = 0; i < n; i++) {
      answer = Math.max(answer, inc[i] + dec[i] - 1); // inc와 dec 둘다 i를 포함하므로 1을 빼줘야함.
    }
    System.out.println(answer);
  }
}
