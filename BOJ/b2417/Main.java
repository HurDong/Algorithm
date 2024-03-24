package b2417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()); // 2^63 이므로 정수형 타입 long으로 설정
        long answer = (long) Math.sqrt(n); // 제곱근을 사용 후 long으로 캐스팅해 소수점 버리기
        if (answer * answer < n) { // n이 어떤 정수의 제곱근이 아닐 경우 answer을 더해줌
            answer++;
        }
        System.out.println(answer);
    }
}
