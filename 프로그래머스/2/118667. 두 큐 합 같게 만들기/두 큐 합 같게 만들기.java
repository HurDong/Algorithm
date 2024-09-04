import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        long s1 = 0;
        long s2 = 0;
        int n = queue1.length;
        for(int i=0;i<n;i++)
        {
            q1.add(queue1[i]);
            s1 += queue1[i];
            q2.add(queue2[i]);
            s2 += queue2[i];
        }
        int max = 3 * n; // 최대 연산 횟수
        int count = 0;
        long sum = ( s1 + s2 )/2;
        while(s1!=sum && count <= max){
            // s1에서 값을 빼야함
            if(s1 > sum){
                int num = q1.poll();
                s1 -= num;
                q2.addLast(num);
            } else{
                int num = q2.poll();
                s1 += num;
                q1.add(num);
            }
            count++;
        }
        return s1 == sum ? count : -1;
    }
}