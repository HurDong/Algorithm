import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        // step 1 : 인접리스트
        ArrayList<Integer>[] list = new ArrayList[n+1]; // 0 제외
        for(int i=1;i<=n;i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++)
        {
            int a = roads[i][0];
            int b = roads[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        // step 2 : bfs
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(destination);
        dist[destination] = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0;i<list[cur].size();i++)
            {
                int next = list[cur].get(i);
                if(dist[next]==-1){
                    dist[next] = dist[cur] +1;
                    queue.add(next);
                }
            }
        }
        // step 3 : dist로 답 구하기
        for(int i=0;i<sources.length;i++)
        {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
}