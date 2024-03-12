package b2331;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();

        int P = sc.nextInt();

        ArrayList<Integer> sequence = new ArrayList<>(); // 수열을 저장할 리스트

        sequence.add(A); // 초기 값 추가

        while (true) {
            int lastElement = sequence.get(sequence.size() - 1); // 마지막 요소
            int nextElement = getNextElement(lastElement, P); // 다음 요소 계산
            // 반복 시작 지점 찾기
            if (sequence.contains(nextElement)) {
                System.out.println(sequence.indexOf(nextElement)); // 반복 시작 전까지의 길이 출력
                break;
            }
            sequence.add(nextElement);
        }
    }

    // 다음 요소를 계산하는 함수
    public static int getNextElement(int current, int P) {
        int next = 0;
        while (current > 0) {
            next += Math.pow(current % 10, P);
            current /= 10;
        }
        return next;
    }
}
