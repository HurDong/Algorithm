import java.util.Scanner;

public class Main {
    static int n,m,answer=0;
    static int[][] room;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        room = new int[n][m];
        visited = new boolean[n][m];
        int rx = sc.nextInt();
        int ry = sc.nextInt();
        int rd = sc.nextInt(); // 0 : 북 / 1 : 동 / 2 : 남 / 3 : 서
        // 0 이면 청소되지 않은 바닥 1 이면 벽 2 이면 청소완료된 바닥
        for(int i=0;i<n;i++)
        {
            for (int j = 0; j < m; j++) {
                {
                    room[i][j] =sc.nextInt();
                }
            }
        }
        dfs(rx,ry,rd);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(room[i][j] == 2) answer++;
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int x, int y, int d){
        room[x][y] = 2;
        boolean isDirt = false;
        for(int i=0;i<4;i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isRange(nx,ny)){
                if(room[nx][ny]==0){
                    isDirt = true;
                }
            }
        }
        if(!isDirt) {
            if (d == 0) {
                // 북쪽 -> 아래로
                int nx = x + dx[1];
                int ny = y + dy[1];
                if (isRange(nx, ny) && room[nx][ny] != 1) {
                    dfs(nx, ny, d);
                } else {
                    return;
                }
            } else if (d == 1) {
                // 동쪽 -> 왼쪽으로
                int nx = x + dx[2];
                int ny = y + dy[2];
                if (isRange(nx, ny) && room[nx][ny] != 1) {
                    dfs(nx, ny, d);
                } else {
                    return;
                }
            } else if (d == 2) {
                // 남쪽 -> 위로
                int nx = x + dx[0];
                int ny = y + dy[0];
                if (isRange(nx, ny) && room[nx][ny] != 1) {
                    dfs(nx, ny, d);
                } else {
                    return;
                }
            } else {
                // 서쪽 -> 오른쪽으로
                int nx = x + dx[3];
                int ny = y + dy[3];
                if (isRange(nx, ny) && room[nx][ny] != 1) {
                    dfs(nx, ny, d);
                } else {
                    return;
                }
            }
        }else{
            rotate(x,y,d);
        }
    }
    public static boolean isRange(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    public static void rotate(int x, int y, int d){
        // 반시계 회전 1은 0되고 0은 3되고 3은 2되고 2는 1되게
        if(d==0) d=3;
        else d--;
        // 바라보는 방향기준으로 앞쪽 칸 전진
        if(d==0){
            // 북쪽
            int nx = x +dx[0];
            int ny = y+ dy[0];
            if(isRange(nx,ny)){
                if(room[nx][ny] ==0) {
                    dfs(nx,ny,d);
                }else{
                    rotate(x,y,d);
                }
            }
        }else if(d==1){
            // 동쪽
            int nx = x +dx[3];
            int ny = y+ dy[3];
            if(isRange(nx,ny)){
                if(room[nx][ny] ==0) {
                    dfs(nx,ny,d);
                }else{
                    rotate(x,y,d);
                }
            }
        }else if(d==2){
            // 남쪽
            int nx = x +dx[1];
            int ny = y+ dy[1];
            if(isRange(nx,ny)){
                if(room[nx][ny] ==0) {
                    dfs(nx,ny,d);
                }else{
                    rotate(x,y,d);
                }
            }
        } else{
            // 서쪽
            int nx = x +dx[2];
            int ny = y+ dy[2];
            if(isRange(nx,ny)){
                if(room[nx][ny] ==0) {
                    dfs(nx,ny,d);
                }else{
                    rotate(x,y,d);
                }
            }
        }
    }
}
