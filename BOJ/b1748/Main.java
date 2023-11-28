package b1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int length = 0;
        int add = 1;

        for (int start = 1; start <= N; start *= 10) {
            int end = start * 10 - 1;
            if (end > N) {
                end = N;
            }
            length += (end - start + 1) * add;
            add++;
        }

        System.out.println(length);
    }
}
