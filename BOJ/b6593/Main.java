package b6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final String prefix = "Escaped in";
    static final String suffix = "minute(s).\n";
    static final String wrong = "Trapped!\n";
    static char[][][] buliding;
    static int L, R, C;
    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };
    static int startX;
    static int startY;
    static int startZ;
    static int endX;
    static int endY;
    static int endZ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());

            R = Integer.parseInt(st.nextToken());

            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0)
                break;

            buliding = new char[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        buliding[i][j][k] = s.charAt(k);
                        if (buliding[i][j][k] == 'S') {
                            startX = i;
                            startY = j;
                            startZ = k;
                            buliding[i][j][k] = '.'; // 이동가능한 곳으로 변환
                        } else if (buliding[i][j][k] == 'E') {
                            endX = i;
                            endY = j;
                            endZ = k;
                            buliding[i][j][k] = '.'; // 이동가능한 곳으로 변환
                        }
                    }
                }
                br.readLine(); // 공백 처리
            }
            // bfs
            int answer = bfs();
            // bfs 후 answer이 0보다 크면 즉, 도착가능한 경우였으면 정답 멘트를 아니라면 Trapped 멘트를 StringBudiler에 저장
            sb.append(answer > 0 ? prefix + " " + answer + " " + suffix : wrong);
        }
        System.out.println(sb.toString());
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { startX, startY, startZ, 0 }); // (x,y,z,이동거리) 배열로 저장

        boolean[][][] visited = new boolean[L][R][C];

        visited[startX][startY][startZ] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // E를 만나면 거리만큼 반환 후 bfs 종료
            if (cur[0] == endX && cur[1] == endY && cur[2] == endZ) {
                return cur[3];
            }
            for (int i = 0; i < 6; i++) {
                int nx = cur[0] + dx[i];

                int ny = cur[1] + dy[i];

                int nz = cur[2] + dz[i];

                if (isRange(nx, ny, nz)) {
                    // S나 E 모두 .으로 바꿨으므로 bfs 이상 X
                    if (!visited[nx][ny][nz] && buliding[nx][ny][nz] == '.') {
                        queue.add(new int[] { nx, ny, nz, cur[3] + 1 });

                        visited[nx][ny][nz] = true;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isRange(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < L && y < R && z < C;
    }

}
