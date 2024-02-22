import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int calcDiff(int[] arr) {
        int sum = 0;
        // 해당 배열의 차이를 계산
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        return sum;
    }

    // 만들 수 있는 모든 경우의 수를 배열로 생성
    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;

        while (i > 0 && arr[i - 1] >= arr[i])
            i--;

        if (i <= 0)
            return false;

        int j = arr.length - 1;

        while (arr[j] <= arr[i - 1])
            j--;

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];

        arr[j] = temp;

        j = arr.length - 1;

        while (i < j) {
            temp = arr[i];

            arr[i] = arr[j];

            arr[j] = temp;

            i++;

            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순으로 정렬
        Arrays.sort(arr);

        int result = 0;

        // 루프에 진입하기 전에 최초의 순열에 대한 계산을 수행
        result = Math.max(result, calcDiff(arr));

        // 다음 순열이 존재하는 동안 반복
        while (nextPermutation(arr)) {
            result = Math.max(result, calcDiff(arr));
        }

        System.out.println(result);
    }
}
