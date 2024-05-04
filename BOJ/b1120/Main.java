package b1120;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        int minDiff = Integer.MAX_VALUE;

        // 가능한 모든 위치에서 A를 B에 비교
        for (int start = 0; start <= B.length() - A.length(); start++) {
            int diff = 0; // 현재 시작 위치에서의 차이를 측정할 변수
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(start + i)) {
                    diff++; // A와 B의 문자가 다르면 차이를 1 증가
                }
            }
            minDiff = Math.min(minDiff, diff); // 최소 차이 업데이트
        }

        System.out.println(minDiff); // 최소 차이 출력
    }
}
