import java.util.*;

class Solution {
    public int solution(String[] board) {
        // 이거는 칸마다 계산하는 것이 아닌 쭉 갔을때 멈춘 그 칸을 queue에 넣어 bfs를 하는 형식
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        int x = -1;
        int y = -1;
        // x,y로 시작점 찾기
        for(int i=0;i<n;i++)
        {
            String s = board[i];
            for(int j=0;j<m;j++){
                if(s.charAt(j)=='R'){
                   x = i;
                    y = j;
                }
            }
        }
        // bfs
        Queue<int[]> queue = new ArrayDeque();
        queue.add(new int[]{x,y});
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],-1);
        }
        dist[x][y]=0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(board[cur[0]].charAt(cur[1])=='G'){
                return dist[cur[0]][cur[1]];
            }
            for(int i=0;i<4;i++)
            {
                // move 메서드로 끝까지 간 좌표를 찾고, 이미 방문했는지 여부 판단
                int[] next = move(board,cur[0],cur[1],dx[i],dy[i]);
                if(dist[next[0]][next[1]]==-1){
                    dist[next[0]][next[1]] = dist[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{next[0],next[1]});
                }
            }
        }
        return -1;
    }
    // 끝까지 가는 메서드
    private int[] move(String[] board, int r, int c, int dr, int dc) {
        int n = board.length;
        int m = board[0].length();

        int nr = r;
        int nc = c;

        while (true) {
            int tr = nr + dr;
            int tc = nc + dc;

            if (tr < 0 || tr >= n || tc < 0 || tc >= m) {
                break;
            }

            if (board[tr].charAt(tc) == 'D') {
                break;
            }

            nr = tr;
            nc = tc;
        }

        return new int[]{nr, nc};
    }
}