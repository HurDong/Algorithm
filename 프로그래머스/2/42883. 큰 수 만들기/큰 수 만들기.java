import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int n = number.length();
        StringBuilder sb = new StringBuilder();
        // n-1-k 자리에서 제일 큰 값을 찾는다. -> 그 자리에서 n-k 자리에서 제일큰 값 -> 반복
        int idx =-1;
        for(int i=0;i<n-k;i++)
        {
            int big =0;
            for(int j=idx+1;j<=k+i;j++){
                if(big<number.charAt(j)-'0'){
                    big = number.charAt(j) -'0';
                    idx = j;
                }
            }
            sb.append(big);
        }
        answer = sb.toString();
        return answer;
    }
}