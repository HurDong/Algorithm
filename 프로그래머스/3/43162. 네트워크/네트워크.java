import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i]){
                dfs(i,computers);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int start, int[][] computers){
        visited[start] = true;
        for(int i=0;i<computers.length;i++)
        {
            if(!visited[i]&&computers[start][i] ==1){
                dfs(i,computers);
            }
        }
    }
}