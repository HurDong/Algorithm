package memo.Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceGame {
    public static int[] bestDice(int[][] dice) {
        int n = dice.length;
        int half = n / 2;
        int[] bestDice = new int[half];
        int maxWins = -1;

        // 모든 주사위 조합 탐색
        for (int i = 0; i < (1 << n); i++) {
            List<int[]> groupA = new ArrayList<>();
            List<int[]> groupB = new ArrayList<>();

            // A와 B 그룹 나누기
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0 && groupA.size() < half) {
                    groupA.add(dice[j]);
                } else {
                    groupB.add(dice[j]);
                }
            }

            // 정확히 n/2 개씩 나누어진 경우만 고려
            if (groupA.size() == half && groupB.size() == half) {
                int wins = countWins(groupA, groupB);
                if (wins > maxWins) {
                    maxWins = wins;
                    int index = 0;
                    for (int j = 0; j < n; j++) {
                        if ((i & (1 << j)) != 0) {
                            bestDice[index++] = j + 1; // 주사위 번호는 1부터 시작
                        }
                    }
                }
            }
        }

        return bestDice;
    }

    // A와 B의 주사위 조합의 승리 횟수 계산
    private static int countWins(List<int[]> groupA, List<int[]> groupB) {
        int wins = 0;

        // A와 B의 모든 가능한 조합에 대한 합 계산
        for (int sumA : getAllSums(groupA)) {
            for (int sumB : getAllSums(groupB)) {
                if (sumA > sumB) {
                    wins++;
                }
            }
        }

        return wins;
    }

    // 주사위 그룹의 모든 가능한 합 계산
    private static List<Integer> getAllSums(List<int[]> group) {
        List<Integer> sums = new ArrayList<>();
        calculateSums(group, 0, 0, sums);
        return sums;
    }

    // 재귀적으로 모든 조합의 합 계산
    private static void calculateSums(List<int[]> group, int index, int currentSum, List<Integer> sums) {
        if (index == group.size()) {
            sums.add(currentSum);
            return;
        }

        for (int face : group.get(index)) {
            calculateSums(group, index + 1, currentSum + face, sums);
        }
    }

    public static void main(String[] args) {
        int[][] dice = {
                { 1, 2, 3, 4, 5, 6 },
                { 3, 3, 3, 3, 4, 4 },
                { 1, 3, 3, 4, 4, 4 },
                { 1, 1, 4, 4, 5, 5 }
        };

        int[] bestDiceForA = bestDice(dice);
        System.out.println("A가 선택해야 할 주사위: " + Arrays.toString(bestDiceForA));
    }
}
