import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] board = new int[102][102]; // 겹치는 부분에 대한 처리를 위한 영역 확장
        // board 설정
        for(int[] rect : rectangle){
            // 사각형 꼭짓점
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            // 내부는 2 테두리는 1로 설정
            for(int i=x1;i<=x2;i++){
                for(int j=y1;j<=y2;j++){
                    // 내부는 2
                    if(x1<i && i<x2 && y1<j && j<y2){
                        board[i][j] = 2;
                    } 
                    // 테두리는 1이지만 겹치면 2로 표시
                    else{
                        if(board[i][j]!=2){
                            board[i][j] = 1;
                        }
                    }
                        
                    }
                }
            }
            return bfs(board, characterX*2, characterY * 2, itemX * 2, itemY * 2);
    }
    public int bfs(int[][] board, int x1, int y1, int x2, int y2){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] visited = new boolean[board.length][board.length];
        Queue<int[]> queue = new ArrayDeque<>();
        // (x좌표,y좌표,이동거리)
        queue.add(new int[]{x1,y1,0});
        visited[x1][y1] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            // 도착하면 이동거리의 반(좌표 두배로 했으니) 반환
            if(x==x2 && y==y2){
                return dist/2;
            }
            
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                // board 안에 있고
                if(nx>=0 && nx<board.length && ny >= 0 && ny < board.length){
                    // 방문하지 않았고 테두리라면
                    if(!visited[nx][ny] && board[nx][ny] ==1){
                        // queue에 넣고 방문 처리
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny,dist+1});
                    }
                }
            }
        }
        // 못 찾았을 경우 -1 반환        
        return -1;
    }
}