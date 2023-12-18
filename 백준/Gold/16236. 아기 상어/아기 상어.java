import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] aqua;
    static boolean[][] visited;
    static int[] baby = new int[2];
    static int babySize = 2; // 초기 아기상어 크기
    static int babyEat = 0; // size만큼 eat을 하면 eat을 0으로 초기화 후 size를 1 증가
    static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
    static int answer = 0;

    public static void main(String[] args) {
        // 자기보다 크면 지나가지도 먹지도 못함
        // 같으면 지나가기만 가능
        // 같은 거리면 위, 왼쪽의 우선순위
        // 자신의 크기만큼의 수를 먹어야 크기 1 증가
        // 아기상어의 초기 크기는 2
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        aqua = new int[n][n];
        visited = new boolean[n][n];
        Shark babyShark = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aqua[i][j] = sc.nextInt();
                if (aqua[i][j] == 9) {
                    aqua[i][j] = 0;
                    babyShark = new Shark(i, j, 0);
                }
            }
        }
        Queue<Shark> queue = new LinkedList<>();
        queue.add(babyShark);
        while (true) {
            // 현재 위치와 현재 크기에서 먹을 수 있는 물고기를 저장할 배열
            ArrayList<Shark> eatable = new ArrayList<>();
            int[][] dist = new int[n][n];
            while (!queue.isEmpty()) {
                Shark cur = queue.poll();
                int x = cur.x;
                int y = cur.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (dist[nx][ny] == 0 && aqua[nx][ny] <= babySize) {
                            dist[nx][ny] = dist[x][y] + 1;
                            queue.add(new Shark(nx, ny, dist[nx][ny]));
                            if (aqua[nx][ny] > 0 && aqua[nx][ny] <= 6 && aqua[nx][ny] < babySize) {
                                eatable.add(new Shark(nx, ny, dist[nx][ny]));
                            }
                        }
                    }
                }
            }
            if (eatable.isEmpty()) {
                System.out.println(answer);
                return;
            }
            // Comparable compareTo 함수가 있으므로 해당 비교 연산자(?)를 기준으로 정렬
            Collections.sort(eatable);
            Shark nextFish = eatable.get(0);
            aqua[nextFish.x][nextFish.y] = 0;
            answer += nextFish.dist;
            babyEat++;
            // 먹고 나서 현재 크기만큼 먹었으면 크기 증가
            if (babyEat == babySize) {
                babySize++;
                babyEat = 0;
            }
            queue.add(nextFish);
        }
    }

    public static class Shark implements Comparable<Shark> {
        int x, y;
        int dist;

        public Shark(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        // 거리가 가까운 순
        // 같으면 x값이 작은 순
        // 같으면 y값이 작은 순
        @Override
        public int compareTo(Shark o) {
            if (this.dist != o.dist)
                return this.dist - o.dist;
            else if (this.x != o.x)
                return this.x - o.x;
            else
                return this.y - o.y;
        }
    }
}
