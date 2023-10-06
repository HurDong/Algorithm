package b1541;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] subtraction = input.split("-");

        int sum = 0;

        String[] firstAddition = subtraction[0].split("\\+");
        for (String num : firstAddition) {
            sum += Integer.parseInt(num);
        }
        // 첫 + 에 대한 처리 완료 -> 1부터
        for (int i = 1; i < subtraction.length; i++) {
            int tempSum = 0;
            String[] addition = subtraction[i].split("\\+");
            for (String num : addition) {
                tempSum += Integer.parseInt(num);
            }
            sum -= tempSum;
        }

        System.out.println(sum);
    }
}
