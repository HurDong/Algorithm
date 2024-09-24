import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        if(scoville[scoville.length-1]==0) return -1;
        for(int i=0;i<scoville.length;i++)
        {
            heap.add(scoville[i]);
        }
        int answer = 0;
        while(heap.peek()<K){
            if(heap.size()==1){
              return -1;  
            }
            int firstFood = heap.poll();
            int secondFood = heap.poll();
            heap.add(firstFood+(secondFood*2));
            answer++;
        }
        return answer;
    }
}