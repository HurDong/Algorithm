package b15596;

public class Main {
    long sum(int[] a) {
        long ans = 0; // 정수의 합이 int의 범위를 넘어갈 수 있으므로 long 타입 사용
        for (int i = 0; i < a.length; i++) {
            ans += a[i];
        }
        return ans; // 모든 요소의 합을 반환
    }
}
