import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int xlen = maps.length;
        int ylen = maps[0].length;
        boolean[][] visited = new boolean[xlen][ylen];
        int[][] count = new int[xlen][ylen];
        visited[0][0] = true;
        count[0][0] = 1;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int[] cur = {0,0};
        while(!queue.isEmpty()){
            cur = queue.poll();
            for(int k=0;k<4;k++)
            {
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];
                if(nx>=0 && ny>=0 && nx<xlen && ny<ylen){
                    if(!visited[nx][ny] && maps[nx][ny]==1){
                        visited[nx][ny]=true;
                        queue.add(new int[]{nx,ny});
                        count[nx][ny] = count[cur[0]][cur[1]]+1;
                    }
                }
            }
        }
        if(count[xlen-1][ylen-1]!=0){
            answer = count[xlen-1][ylen-1];
        }else{
            answer = -1;
        }
        return answer;
    }
}