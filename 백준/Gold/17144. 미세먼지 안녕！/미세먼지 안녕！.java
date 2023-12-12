import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int firstClean = 0; // x값은 항상 0
        int[][][] house = new int[R][C][2]; // 확산전 배열 [][][0], 확산 중 증가값을 [1]에 저장한다.
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                house[i][j][0] = Integer.parseInt(st.nextToken());
                if (house[i][j][0] == -1 && firstClean == 0) {
                    firstClean = i;
                }
            }
        }
        while (T-- > 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    house[i][j][1] = 0;
                }
            }
            // 일단 확산을 먼저 한다.
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int count = 0;
                    if (house[i][j][0] > 0) {
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                                if (house[nx][ny][0] != -1) {
                                    house[nx][ny][1] += (house[i][j][0] / 5);
                                    count++;
                                }
                            }
                        }
                    }
                    house[i][j][1] -= (house[i][j][0] / 5) * count;
                }
            }
            // house[i][j][0]에 house[i][j][1]를 더한다.
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (i == firstClean || i == firstClean + 1) {
                        if (j == 0) {
                            house[i][j][0] = 0;
                            continue;
                        }
                    }
                    house[i][j][0] += house[i][j][1];
                }
            }
            /*
             * System.out.println("==========확산후===========");
             * for (int i = 0; i < R; i++) {
             * for (int j = 0; j < C; j++) {
             * System.out.print(house[i][j][0] + " ");
             * }
             * System.out.println();
             * }
             */
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    house[i][j][1] = house[i][j][0];
                }
            }
            // 그 다음 바람을 계산 한다.공기청정기로 들어간 미세먼지는 정화된다.
            // 1. 첫번째 공기청정기의 위,아래
            for (int i = 0; i < firstClean; i++) {
                house[i + 1][0][1] = house[i][0][0];
                house[firstClean - (i + 1)][C - 1][1] = house[firstClean - i][C - 1][0];
            }

            // 2. 첫번째 공기청정기의 왼쪽,오른쪽, 두번째 공기청정기의 왼쪽,오른쪽
            for (int i = 0; i < C - 1; i++) {
                house[0][(C - 1) - (i + 1)][1] = house[0][(C - 1) - i][0];
                house[firstClean][i + 1][1] = house[firstClean][i][0];
                house[firstClean + 1][i + 1][1] = house[firstClean + 1][i][0];
                house[R - 1][(C - 1) - (i + 1)][1] = house[R - 1][(C - 1) - i][0];
            }

            // 3. 두번째 공기청정기의 위,아래
            for (int i = 0; i < R - (firstClean + 2); i++) {
                house[(R - 1) - (i + 1)][0][1] = house[(R - 1) - i][0][0];
                house[(firstClean + 1) + (i + 1)][C - 1][1] = house[(firstClean + 1) + i][C - 1][0];
            }
            // house[i][j][0] 값 할당 및 house[i][j][1] 초기화
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    house[i][j][0] = house[i][j][1];
                }
            }
            house[firstClean][0][0] = -1;
            house[firstClean + 1][0][0] = -1;
            /*
             * System.out.println("===========정화후==========");
             * for (int i = 0; i < R; i++) {
             * for (int j = 0; j < C; j++) {
             * System.out.print(house[i][j][0] + " ");
             * }
             * System.out.println();
             * }
             */
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += house[i][j][0];
            }
        }
        System.out.println(answer + 2);
    }
}
