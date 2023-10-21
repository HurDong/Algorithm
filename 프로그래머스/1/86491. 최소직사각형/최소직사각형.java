import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        // 제일 큰 거까지 구하는건 맞다. -> 모든 원소에 대해서 더 작은 이중배열의 배열 값 중 제일 큰 것을 구한다.
        int big = Integer.MIN_VALUE;
        for(int i=0;i<sizes.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                if(big<sizes[i][j]) big = sizes[i][j];
            }
        }
        int nextBig =Integer.MIN_VALUE;
        for( int i=0;i<sizes.length;i++)
        {
            int ss;
            if(sizes[i][0]>sizes[i][1]){
                 ss = sizes[i][1];
            }else{
                 ss = sizes[i][0];
            }
            if(nextBig<ss){
                nextBig = ss;
            }
        }
        answer = big * nextBig;
        return answer;
    }
}