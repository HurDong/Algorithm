import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++)
        {
            queue.add(new int[]{priorities[i],i});
        }
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            boolean isMax = true;
            // 더 높은 우선순위(curQueue[0]) 있는 지 탐색
            for(int[] curQueue : queue){
                if(curQueue[0]>cur[0]){
                    isMax =false;
                    break;
                }
            }
            if(isMax){
                answer++;
                if(location==cur[1]){
                    break;
                }
            }else{
                queue.add(cur);
            }
        }
        return answer;
    }
}