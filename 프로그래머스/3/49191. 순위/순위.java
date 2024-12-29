import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        // step 1 : 양방향 그래프 완성
        boolean[][] graph = new boolean[n+1][n+1];
        for(int[] result : results){
            graph[result[0]][result[1]] = true;
        }
        // step 2 : 플로이드 워샬 사용 -> 모든 상하관계 반영
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                for(int k=1;k<=n;k++)
                {
                    if(graph[j][i] && graph[i][k]){
                        graph[j][k] = true;
                    }
                }
            }
        }
        
        // 이긴 횟수와 진 횟수의 합이 n-1일경우만 순위를 정확하게 알 수 있음
        for(int i=1;i<=n;i++)
        {
            int wins=0, loses=0;
            for(int j=1;j<=n;j++)
            {
                if(graph[i][j]) wins++;
                if(graph[j][i]) loses++;
            }
            if(wins+loses == n-1) answer++;
        }
        return answer;
    }
}