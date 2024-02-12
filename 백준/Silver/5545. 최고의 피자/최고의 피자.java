import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int A = sc.nextInt();

        int B = sc.nextInt();

        int C = sc.nextInt();

        Integer[] toppings = new Integer[N];

        for (int i = 0; i < N; i++) {
            toppings[i] = sc.nextInt();
        }

        Arrays.sort(toppings, (a, b) -> b - a); // 토핑 칼로리를 내림차순으로 정렬

        int totalPrice = A;

        int totalCalories = C;

        double maxRatio = (double) C / A; // 도우만 있는 경우의 칼로리 대비 가격 비율

        for (int i = 0; i < N; i++) {
            int newTotalPrice = totalPrice + B;

            int newTotalCalories = totalCalories + toppings[i];

            double newRatio = (double) newTotalCalories / newTotalPrice;

            // 새로운 토핑을 추가했을 때 비율이 더 좋아지면 업데이트
            if (newRatio > maxRatio) {
                maxRatio = newRatio;
                totalPrice = newTotalPrice;
                totalCalories = newTotalCalories;
            }
            // 더 이상 비율이 좋아지지 않으면 중단
            else {
                break;
            }
        }
        System.out.println((int) maxRatio);
    }
}
