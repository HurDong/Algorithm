package b1431;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] serials = new String[N];

        for (int i = 0; i < N; i++) {
            serials[i] = sc.next();
        }

        Arrays.sort(serials, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length(); // 길이에 따라 정렬
            } else {
                if (sumOfNumbers(a) != sumOfNumbers(b)) {
                    return sumOfNumbers(a) - sumOfNumbers(b); // 숫자 합에 따라 정렬
                } else {
                    return a.compareTo(b); // 사전 순 정렬
                }
            }
        });
        // 차례대로 정답을 출력
        for (String serial : serials) {
            System.out.println(serial);
        }
    }

    // 시리얼 번호에서 숫자들의 합을 계산하는 메서드
    private static int sumOfNumbers(String serial) {
        int sum = 0;
        for (char ch : serial.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += ch - '0'; // 숫자일 경우 더함
            }
        }
        return sum;
    }
}
