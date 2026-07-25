import java.util.*;

class Solution {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int n = board.length;
        int INF = Integer.MAX_VALUE;

        int[][][] cost = new int[n][n][4];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                Arrays.fill(cost[y][x], INF);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        // 오른쪽 시작
        if (n > 1 && board[0][1] == 0) {
            cost[0][1][3] = 100;
            queue.offer(new int[]{0, 1, 3, 100});
        }

        // 아래쪽 시작
        if (n > 1 && board[1][0] == 0) {
            cost[1][0][1] = 100;
            queue.offer(new int[]{1, 0, 1, 100});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int y = cur[0];
            int x = cur[1];
            int dir = cur[2];
            int currentCost = cur[3];

            // // 이미 더 저렴한 경로가 발견된 상태
            // if (currentCost > cost[y][x][dir]) {
            //     continue;
            // }

            for (int nextDir = 0; nextDir < 4; nextDir++) {
                int ny = y + dy[nextDir];
                int nx = x + dx[nextDir];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    continue;
                }

                if (board[ny][nx] == 1) {
                    continue;
                }

                int nextCost;

                if (dir / 2 == nextDir / 2) {
                    nextCost = currentCost + 100;
                } else {
                    nextCost = currentCost + 600;
                }

                if (nextCost < cost[ny][nx][nextDir]) {
                    cost[ny][nx][nextDir] = nextCost;
                    queue.offer(new int[]{ny, nx, nextDir, nextCost});
                }
            }
        }

        int answer = INF;

        for (int dir = 0; dir < 4; dir++) {
            answer = Math.min(answer, cost[n - 1][n - 1][dir]);
        }

        return answer;
    }
}