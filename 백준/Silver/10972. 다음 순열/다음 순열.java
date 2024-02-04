import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (nextPermutation(arr)) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }

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
}
