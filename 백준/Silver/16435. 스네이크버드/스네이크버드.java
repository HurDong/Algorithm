import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int l = sc.nextInt();  
        int[] fruits = new int[n];

        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }

        Arrays.sort(fruits);  // 과일의 높이를 오름차순으로 정렬

        for (int fruit : fruits) {
            if (fruit <= l) {
                l++;  // 과일을 먹고 길이 증가
            } else {
                break;  // 더 이상 먹을 수 없는 경우
            }
        }

        System.out.println(l);
    }
}
