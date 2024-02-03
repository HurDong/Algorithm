package memo.Code.SubsetSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubsetSumToSet {
    public static void main(String[] args) {
        // 예시 입력: 부분집합의 합
        int[] subsetSums = { 1, 2, 3, 4, 5, 6, 7 };

        // 원래 집합 찾기
        Set<Integer> originalSet = findOriginalSet(subsetSums);

        // 결과 출력
        System.out.println("원 집합의 원소: " + originalSet);
    }

    public static Set<Integer> findOriginalSet(int[] subsetSums) {
        Arrays.sort(subsetSums); // 부분집합 합을 오름차순 정렬

        Set<Integer> originalSet = new HashSet<>();
        Set<Integer> currentSums = new HashSet<>();

        for (int sum : subsetSums) {
            // 새 원소 찾기
            if (!currentSums.contains(sum)) {
                originalSet.add(sum);
                Set<Integer> newSums = new HashSet<>(currentSums);
                for (int s : currentSums) {
                    newSums.add(s + sum);
                }
                newSums.add(sum);
                currentSums = newSums;
            }
        }

        return originalSet;
    }
}
