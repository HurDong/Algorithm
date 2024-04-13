import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int[] minus = {-1}; // 정답이 아닐경우 return할 배열
        
        // s가 n보다 작은 경우는 0을 포함하므로 -1을 return
        if(s < n){
            return minus;
        } 
        // div를 n빵
        int div = s / n;
        // 나머지를 rem빵하기 위해 설정
        int rem = s % n;
        // 먼저 n빵
        Arrays.fill(answer,div); 
        // 나머지를 맨 뒤에서부터 rem빵
        if(rem > 0){
            for(int i=0;i<rem;i++)
            {
                // 뒤에서부터 +1
                answer[n-1-i] ++;
            }
        } 
        
        return answer;
    }
}