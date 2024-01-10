import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m,draws=0,maxSize=0;
    static int[][] paper;
    static  boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
         paper = new int[n][m];
         visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                paper[i][j] = sc.nextInt();
            }
        }
        for (int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j]&&paper[i][j]==1){
                    visited[i][j] = true;
                    bfs(i,j);
                }
            }
        }
        System.out.println(draws +"\n"+maxSize);
    }
    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int size = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0;i<4;i++)
            {
                int nx= cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m)
                {
                    if(!visited[nx][ny] && paper[nx][ny]==1)
                    {
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny]=true;
                        size++;
                    }
                }
            }
        }
        draws++;
        maxSize = Math.max(maxSize,size);
    }
}
