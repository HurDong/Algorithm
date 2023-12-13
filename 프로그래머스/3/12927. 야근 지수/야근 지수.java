import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // 야근 피로도 공식 = 남은 야근 제곱의 합 -> 가장 큰수부터 1씩 낮춘다.
        // 1시간에 1만큼 가능 
        long answer = 0;
        int len = works.length;
        PriorityQueue<Integer> workQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<len;i++)
        {
            workQueue.add(works[i]);
        }
        for(int i=0;i<n;i++)
        {
            int highWork = workQueue.poll(); // 가장 높은 피로도를 창출할 work 가져온다.
            if(highWork!=0) {
            highWork--;
            }
            workQueue.add(highWork);
        }
        for(int i=0;i<len;i++)
        {
            answer += pow(workQueue.poll());
        }
        return answer;
    }
    public int pow(int work){
        return (int) Math.pow(work,2);
    }
}