import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int length = input.length();
        String[] suffixArray = new String[length];

        for (int i = 0; i < length; i++) {
            suffixArray[i] = input.substring(i);
        }

        Arrays.sort(suffixArray);

        for (String suffix : suffixArray) {
            System.out.println(suffix);
        }
    }
}
