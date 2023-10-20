import java.util.*;

class Solution {
    private int count = 0;
    public int solution(int[] numbers, int target) {
        int index = 0;
        int len = numbers.length;
        dfs(numbers, target, index, len, 0);
        return count;
    }
    public void dfs(int[] numbers, int target, int index, int len, int sum) {
        if (index == len) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(numbers, target, index + 1, len, sum + numbers[index]);
        dfs(numbers, target, index + 1, len, sum - numbers[index]);
    }
}