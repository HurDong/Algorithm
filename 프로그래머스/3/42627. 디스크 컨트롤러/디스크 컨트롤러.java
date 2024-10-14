import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 출발 시간 오름차순으로 정렬
        // 같으면 걸리는 시간 오름차순으로 정렬
        Arrays.sort(jobs,((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        }));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            else{
                return a[1]-b[1];
            }
        });
        int endTime = 0;
        int n = jobs.length;
        int idx = 0;
        for(int i=0;i<n;)
        {
            // 종료 시간에 할 수 있는 업무들을 PQ에 넣는다.
            while(idx < n && jobs[idx][0] <= endTime){
                queue.add(jobs[idx]);
                idx++;
            }
            // 들어갈 업무가 없으면 endTime을 조정한다.
            if(queue.isEmpty()){
                endTime = jobs[idx][0];
            } 
            // 존재한다면 업무를 진행한다.
            else{
                int[] job = queue.poll();
                answer += ((endTime-job[0])+job[1]);
                endTime += job[1];
                i++;
            }
        }
        return answer  / n;
    }
}