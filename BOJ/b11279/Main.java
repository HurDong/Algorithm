package b11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // gcd(b-a, a) 구하기
        long gcd = gcd(b - a, a);

        // 결과 출력: gcd(b-a, a) - 1
        System.out.println(gcd - 1);
    }

    // 최대공약수(greatest common divisor)를 구하는 함수
    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
