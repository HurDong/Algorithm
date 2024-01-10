import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int l,curx,cury,tx,ty,answer;

    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0)
        {
            l = sc.nextInt();
            curx = sc.nextInt();
            cury = sc.nextInt();
            visited = new boolean[l][l];
            tx = sc.nextInt();
            ty = sc.nextInt();
            answer = Integer.MAX_VALUE;
            visited[curx][cury] = true;
            System.out.println(bfs(curx,cury,0));
        }
    }
    public static int bfs(int x, int y, int count){
       Queue<int[]> queue = new LinkedList<>();
       queue.add(new int[]{x,y,count});
       visited[x][y] = true;
       while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==tx && cur[1]==ty){
                return cur[2];
            }
            for(int i=0;i<8;i++){
                int nx = cur[0]  + dx[i];
                int ny = cur[1] + dy[i];
                if(nx>=0&&ny>=0&&nx<l&&ny<l){
                    if(!visited[nx][ny]){
                        queue.add(new int[]{nx,ny,cur[2]+1});
                        visited[nx][ny]=true;
                    }
                }
            }
       }
       return 0;
    }
}
