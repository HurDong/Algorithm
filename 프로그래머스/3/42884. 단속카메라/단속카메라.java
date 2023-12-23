import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); // 종료 구간의 오름차순으로 정렬
        for (int[] route : routes) {
            // 카메라가 이전에 없으면 종료 구간에 카메라 설치
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}