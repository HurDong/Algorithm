import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                answer[i]++;
                if(prices[i]>prices[j]){
                    break;
                }
            }
        }
        return answer;
    }
}