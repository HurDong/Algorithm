import java.util.*;

class Solution {
    public boolean[] visited;
    public boolean[] isConnected;
    public int[][] computers;
    public int answer;
    public int n;
    public int solution(int n, int[][] computers) {
        isConnected = new boolean[n];
        this.computers = computers;
        this.n = n;
        for(int i=0;i<n;i++)
        {
            if(!isConnected[i]){
                bfs(i);
            }   
        }
        return answer;
    }
    public void bfs(int start){
        isConnected[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited = new boolean[n];
        visited[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0;i<n;i++)
            {
                if(computers[cur][i]==1 && !visited[i]){
                    visited[i] = true;
                    isConnected[i] = true;
                    queue.add(i);
                }
            }
        }
        answer++;
        return;
    }
}