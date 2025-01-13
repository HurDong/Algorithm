import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        // 오름차순으로 바위 정렬
        Arrays.sort(rocks);
        // 이분탐색을 위한 left right 초기 설정
        int left = 1;
        int right = distance;
        while(left<=right){
            // mid를 최소 거리로 설정
            int mid = (left + right) / 2;
            int prev = 0;
            int count = 0;
            for(int rock : rocks){
                // 최소 거리보다 작으므로 삭제한다고 생각
                if(rock - prev < mid){
                    count++; 
                }                
                // 아니라면 건너뛴다
                else{
                    prev = rock;
                }
            }
            // 마지막 돌도 시행
            if(distance - prev < mid){count++;}
            // 너무 많이 삭제할 경우 최소거리를 줄일 필요가 있다.
            if(count > n ){
                right = mid - 1;
            } 
            // 너무 적게 삭제할 경우 최소거리를 늘릴 필요가 있다.
            else{
                left = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }
}