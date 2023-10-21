import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // nextInt했으니까 같은 줄 빈 버퍼 받기.

        String[] files = new String[N];
        for (int i = 0; i < N; i++) {
            files[i] = sc.nextLine();
        }

        StringBuilder pattern = new StringBuilder(files[0]); // 첫 번째 파일 이름을 기준으로

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) != files[i].charAt(j)) {
                    pattern.setCharAt(j, '?');
                }
            }
        }

        System.out.println(pattern.toString());
    }
}
