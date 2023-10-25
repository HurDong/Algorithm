import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int idx =0;
        List<Integer> list = new ArrayList<>();
        // 큐에 다 넣는다. peek가 100을 넘으면 100미만 나올 때까지 poll
        for(int i=0;i<progresses.length;i++)
        {
            queue.add(progresses[i]);
        }
        while(!queue.isEmpty()){
            int count =0;
            while(!queue.isEmpty() && queue.peek()>=100){
                queue.poll();
                count++;
                idx++;
                
            }
            if(count>0) list.add(count);
            if(queue.isEmpty()) break;
            int tempIdx=idx;
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                int tempNum = queue.poll();
                tempNum += speeds[tempIdx];
                tempIdx++;
                queue.add(tempNum);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            answer[i] = list.get(i);
        }
        return answer;
    }
}