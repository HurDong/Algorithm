import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] bmi = new int[n][3];
        for (int i = 0; i < n; i++) {
            bmi[i][0] = sc.nextInt();
            bmi[i][1] = sc.nextInt();
            bmi[i][2] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (bmi[i][0] < bmi[j][0] && bmi[i][1] < bmi[j][1]) {
                        bmi[i][2]++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(bmi[i][2] + " ");
        }
    }
}
