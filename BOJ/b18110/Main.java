package b18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int avgN = (int) Math.round(n * 0.15);
        int sum = 0;
        int avg = 0;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rank);
        for (int i = avgN; i < n - avgN; i++) {
            sum += rank[i];
        }
        int num = n - (2 * avgN);
        avg = (int) Math.round((double) sum / num);
        System.out.println(avg);
    }
}
