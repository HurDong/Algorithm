package b1509;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int n = s.length();

        int[][] dp = new int[n][n]; // dp[i][j] : i번째~j번째 문자열일때

        // i+1 ~ j 와 i ~ j-1을 합치면 i~j가되는건가?
    }
}
