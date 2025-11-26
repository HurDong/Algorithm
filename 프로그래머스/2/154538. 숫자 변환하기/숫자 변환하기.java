import java.util.*;

class Solution {
    // 메모리 초과 해결을 위해 visited 도입
    public static boolean[] visited = new boolean[3000000];
    public int solution(int x, int y, int n) {
        // step 1 : bfs로 가장 가까운 연산들부터 계산
        return bfs(x,y,n);
    }
  
    public int bfs(int x, int y, int n){
        Queue<int[]> queue = new ArrayDeque<>();
        // 좌표 x에 연산 횟수 0 먼저 넣기
        queue.add(new int[]{x,0});
        visited[x] = true;
        // step 2 : bfs 실행
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int pos = cur[0];
            int dist = cur[1];
            // step 3 : 도착했으면 거리 반환(bfs이므로 최소 보장)
            if(pos==y) return dist;
            if(pos>y) continue;
            // 다음 좌표 미리 계산하여 배열에 저장
            int[] next = {pos+n,pos*2,pos*3};
            // 모든 좌표에 대하여 범위 내일 경우만 queue에 넣기
            for(int num : next){
                if(num<=y){
                    // 방문 안한 좌표에 대해서만 수행
                    if(!visited[num]){
                        visited[num] = true;
                        queue.add(new int[]{num,dist+1});
                    }
                }
            }
            
        }
        return -1;
    }
}