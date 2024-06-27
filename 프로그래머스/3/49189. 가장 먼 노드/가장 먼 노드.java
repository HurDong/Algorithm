import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<=n;i++)
        {
            list.add(new ArrayList<>());
        }
        
        // 양방향 그래프
        for(int i=0;i<edge.length;i++)
        {
            int start = edge[i][0];
            
            int end = edge[i][1];
            
            list.get(start).add(end);
            
            list.get(end).add(start);
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{1,0}); // (좌표,거리)
        
        boolean[][] visited = new boolean[n+1][n+1];
        
        int[] dist = new int[n+1]; // 거리 배열
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[1] = 0;
        
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for(int i=0;i<list.get(cur[0]).size();i++)
            {
                int next = list.get(cur[0]).get(i);
                if(!visited[cur[0]][next]){
                    queue.add(new int[]{next,cur[1]+1});
                    dist[next] = Math.min(dist[next],cur[1]+1);
                    visited[cur[0]][next] = true;
                }
            }
        }
        int maxDist = 0;
        for(int i=2;i<=n;i++)
        {   
            if(maxDist<dist[i]){
                maxDist = dist[i];
            }
        }
        for(int i=2;i<=n;i++)
        {   
            if(dist[i]==maxDist){
                answer++;
            }
        }
        return answer;
    }
}