import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(o1,o2)->{
            if(o1[1]==o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int idx = -1;
        for(int[] target : targets){
            int s = target[0];
            int e = target[1];
            if(s>=idx){
                answer++;
                idx = e;
            }
        }
        return answer;
    }
}