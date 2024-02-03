import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt(); 

        Arrays.sort(arr); 

        int count = 0; 
        int start = 0; // 시작 포인터
        int end = n - 1; // 끝 포인터
        
        // 투포인터 사용
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == x) {
                count++;
                start++;
                end--;
            } else if (sum < x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
