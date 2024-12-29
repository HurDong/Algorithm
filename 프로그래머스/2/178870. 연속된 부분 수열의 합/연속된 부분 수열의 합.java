import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0, right = 0, sum = 0; // 투 포인터 사용
        int[] answer = {-1, -1};
        int minLength = Integer.MAX_VALUE; // 최소 길이를 저장
        
        while (right < n) {
            sum += sequence[right];
            // 크면 우로 이동
            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }
            
            // 같으면 답 최신화
            if (sum == k) {
                int length = right - left + 1;
                // 최소 길이만 정답 최신화 가능
                if (length < minLength) { 
                    minLength = length;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            
            right++;
        }
        return answer;
    }
}