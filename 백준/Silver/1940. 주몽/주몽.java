import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  
        int M = sc.nextInt(); 
        
        int[] materials = new int[N];

        for (int i = 0; i < N; i++) {
            materials[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(materials);

        // 투 포인터 선언
        int left = 0;
        int right = N - 1;

        int count = 0;

        // 합 m 인 경우 찾을 때 left가 right를 넘어가면 안됨
        while (left < right) {
            int sum = materials[left] + materials[right];
            if (sum == M) {
                count++;
                left++;
                right--;
            } else if (sum < M) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
