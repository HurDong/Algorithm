import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y1 = sc.nextInt();
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int y2 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int total1 = calcDay(y1, m1, d1);
        int total2 = calcDay(y2, m2, d2);

        if (y2 - y1 > 1000 || y2 - y1 == 1000 && (m1 < m2 || m1 == m2 && d1 <= d2))
            System.out.println("gg");
        else
            System.out.println("D-" + (total2 - total1));
    }

    static int calcDay(int y, int m, int d) {
        int[] day = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int days = 0;

        for (int i = 1; i < y; i++) {
            days += 365 + checkYear(i);
        }

        for (int i = 1; i < m; i++) {
            if (i == 2)
                days += checkYear(y);
            days += day[i];
        }

        days += d;

        return days;
    }

    static int checkYear(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            return 1;
        else
            return 0;
    }
}
