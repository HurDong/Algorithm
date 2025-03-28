import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        
        // Step 1: A와 B의 합을 저장
        int[] sumAB = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumAB[idx++] = A[i] + B[j];
            }
        }
        
        // Step 2: C와 D의 합을 저장
        int[] sumCD = new int[n * n];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumCD[idx++] = C[i] + D[j];
            }
        }
        
        // Step 3: sumAB와 sumCD를 정렬
        Arrays.sort(sumAB);
        Arrays.sort(sumCD);
        
        // Step 4: 투 포인터를 사용하여 합이 0인 경우의 수 계산
        long count = 0;
        int left = 0;
        int right = sumCD.length - 1;
        
        while (left < sumAB.length && right >= 0) {
            int sum = sumAB[left] + sumCD[right];
            
            if (sum == 0) {
                // sumAB[left]와 sumCD[right]의 동일한 값의 개수를 계산
                long countAB = 1;
                long countCD = 1;
                
                while (left + 1 < sumAB.length && sumAB[left] == sumAB[left + 1]) {
                    left++;
                    countAB++;
                }
                
                while (right - 1 >= 0 && sumCD[right] == sumCD[right - 1]) {
                    right--;
                    countCD++;
                }
                
                count += countAB * countCD;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        
        // 결과 출력
        System.out.println(count);
    }
}
