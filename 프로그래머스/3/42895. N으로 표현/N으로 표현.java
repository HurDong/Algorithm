import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N==number) return 1;
        List<Set<Integer>> dp = new ArrayList<>(); // dp : i번째에 있는 set은 최소 i+1개의 return을 갖는다.
        int n = N;
        for(int i=0;i<8;i++)
        {
            Set<Integer> set = new HashSet<>();
            set.add(n);
            dp.add(set);
            n = n*10+N; // 5 -> 55 -> 555 -> ...
        }
        for(int i=1;i<8;i++) // dp[0] = 자기 자신만 존재
        {
            for(int j=0;j<i;j++)
            {
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j-1)){
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b); 
                        dp.get(i).add(a*b);
                        if(b!=0) dp.get(i).add(a/b);
                    }
                }
            }
            // number가 있으면 i+1 반환
            if(dp.get(i).contains(number)){
                return i+1;
            }
        }
        // 모든 dp[7]까지 존재하지 않는 수일 경우 -1 반환
        return -1;
    }
}