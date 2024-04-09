import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int idx = 0;
        int num = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < bridge_length  ; i++)
        {
            queue.add(0);
        }
        while(!queue.isEmpty()) {
            answer++;
            if(idx == truck_weights.length){
                queue.poll();
                continue;
            }
            int target = queue.poll();
            if(target > 0){
                num--;
            }
            sum-=target;
            if(sum + truck_weights[idx] <= weight && num + 1 <= bridge_length){
                sum+=truck_weights[idx];
                num++;
                queue.add(truck_weights[idx]);
                idx++;
            } else {
                queue.add(0);
            }
           
        }
        return answer;
    }
}