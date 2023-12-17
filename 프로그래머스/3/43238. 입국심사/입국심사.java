import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 지금 내가 갈려고 하는 심사대보다 기다렸다가 가면 빨리 끝나는  심사대가 있으면 갈 수 있다.
        long answer = (long) times[times.length-1]*n; // 최악의 경우(시간이 가장 오래걸리는 심사대에서만 심사를 받을때)를 먼저 answer로 설정
        Arrays.sort(times); // 오름차순으로 정렬
        long max = (long) times[times.length-1]*n; // 마지막 시간 탐색
        long min = 1, sum = 0; // 최소 시간은 1분 이상
        long mid = (min*max) / 2;
        // 이분탐색을 이용한 1~최악의 경우 범위에서 탐색
        while(min<=max){
            sum =0;
            mid=(min+max)/2;
            for(int time : times)
            {
                // mid시간동안 한 심사대당 몇명 처리 가능한지 더해줌 
                sum += mid/time;
            }
            if(sum>=n)
            {
                answer = mid;
                max = mid -1;
            }
            else{
                // 불가능한 경우
                min = mid +1;
            }
        }
        // 결국 최솟값을 찾기 위해 이분탐색을 이용하여 가능한 시간을 찾아도 범위를 좁혀나가야한다.
        return answer;
    }
}