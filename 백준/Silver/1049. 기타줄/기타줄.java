import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int minPackagePrice = Integer.MAX_VALUE;
        int minIndividualPrice = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            int packagePrice = sc.nextInt();
            int individualPrice = sc.nextInt();

            minPackagePrice = Math.min(minPackagePrice, packagePrice);
            minIndividualPrice = Math.min(minIndividualPrice, individualPrice);
        }

        int minCost = Math.min(
                ((N / 6) + 1) * minPackagePrice, 
                N * minIndividualPrice
        );
        minCost = Math.min(minCost, 
                (N / 6) * minPackagePrice + (N % 6) * minIndividualPrice
        );

        System.out.println(minCost);
        sc.close();
    }
}
