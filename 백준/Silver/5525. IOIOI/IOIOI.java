import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        int result = 0;
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            // 'IOI'를 찾는다
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                count++;
                // 2n+1의 길이가 될 때까지 찾는다. 같으면 정답에 추가
                if (count == n) {
                    count--;
                    result++;
                }
                i++; // i-1 i i+1에 대해서 비교하므로 한번 더 증가를 시켜줘야함.
            } else {
                count = 0;
            }
        }
        System.out.println(result);
    }
}
