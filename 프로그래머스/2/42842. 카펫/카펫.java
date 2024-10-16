import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        // 길이는 무조건 3이상
        for(int i=3;i<=sum;i++)
        {
            int col = i;
            int row = sum / i;
            // 길이는 무조건 3이상
            if(row<3) continue;
            if((col-2)  * (row-2) == yellow){
                answer[0] = row;
                answer[1] = col;
                break;
            }
        }
        return answer;
    }
}