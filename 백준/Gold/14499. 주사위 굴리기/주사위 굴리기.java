import java.util.Scanner;

public class Main {
    static int n, m, x, y, k;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    // dice 면 저장(up, behind, right, left, front, down)
    static int[] dice = new int[7];
    // 동서남북 dir
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0, };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        m = sc.nextInt();

        x = sc.nextInt();

        y = sc.nextInt();

        k = sc.nextInt();

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            // System.out.println((i + 1) + "th Instruction\n Up : " + dice[1] + " Behind :
            // " + dice[2] + " right : "
            // + dice[3] + " left : " + dice[4]
            // + " front : " + dice[5] + " down : " + dice[6]);
            int dir = sc.nextInt() - 1;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            int[] tempDice = new int[7];
            // 얕은 복사
            for (int j = 1; j <= 6; j++) {
                tempDice[j] = dice[j];
            }
            // 이동 가능한지
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // 동쪽 -> front behind 고정
                if (dir == 0) {
                    dice[1] = tempDice[4];
                    dice[3] = tempDice[1];
                    dice[4] = tempDice[6];
                    dice[6] = tempDice[3];
                }
                // 서쪽 -> front behind 고정
                else if (dir == 1) {
                    dice[1] = tempDice[3];
                    dice[3] = tempDice[6];
                    dice[4] = tempDice[1];
                    dice[6] = tempDice[4];
                }
                // 북쪽 -> left, right 고정
                else if (dir == 2) {
                    dice[1] = tempDice[5];
                    dice[2] = tempDice[1];
                    dice[5] = tempDice[6];
                    dice[6] = tempDice[2];
                }
                // 남쪽 -> left, right 고정
                else {
                    dice[1] = tempDice[2];
                    dice[2] = tempDice[6];
                    dice[5] = tempDice[1];
                    dice[6] = tempDice[5];
                }
                if (board[nx][ny] == 0) {
                    board[nx][ny] = dice[6];
                } else {
                    dice[6] = board[nx][ny];
                    board[nx][ny] = 0;
                }
                // 답 저장
                sb.append(dice[1] + "\n");
                // 이동
                x = nx;
                y = ny;
            }
        }
        // 답 출력
        System.out.println(sb.toString());
    }
}
