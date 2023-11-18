import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                    continue;
                }
                if(j==i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j]; 
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
            }
        }
        int[] last = dp[n-1];
        Arrays.sort(last);
        answer = last[n-1];
        return answer;
    }
}