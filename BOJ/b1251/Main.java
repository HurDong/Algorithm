package b1251;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String result = null;

        for (int i = 1; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                String a = new StringBuilder(input.substring(0, i)).reverse().toString();
                String b = new StringBuilder(input.substring(i, j)).reverse().toString();
                String c = new StringBuilder(input.substring(j)).reverse().toString();
                String combined = a + b + c;

                if (result == null || combined.compareTo(result) < 0) {
                    result = combined;
                }
            }
        }

        System.out.println(result);
    }
}
