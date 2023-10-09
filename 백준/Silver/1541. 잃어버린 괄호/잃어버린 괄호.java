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
