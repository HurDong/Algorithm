package b12100;

import java.util.Scanner;

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int answer = 2;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                // 시행 전 가장 큰 블록의 값을 저장
                answer = Math.max(answer, board[i][j]);
            }
        }

        // 2048 게임 시작
        init(board, 0);

        // 5번 이동 시 가장 큰 블록의 값을 출력
        System.out.println(answer);
    }

    private static void init(int[][] board, int count) {
        // 0 : 상 / 1 : 하 / 2 : 좌 / 3 : 후
        dfs(board, count, 0);
        dfs(board, count, 1);
        dfs(board, count, 2);
        dfs(board, count, 3);
    }

    private static void dfs(int[][] board, int count, int dir) {
        // 게임 5회 실행 시 종료
        if (count == 5) {
            return;
        }

        // 상
        if (dir == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board = execute(board, i, j, dir);
                }
            }
        }
        // 하
        else if (dir == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board = execute(board, (n - 1) - i, j, dir);
                }
            }
        }
        // 좌
        else if (dir == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board = execute(board, i, j, dir);
                }
            }
        }
        // 우
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board = execute(board, i, (n - 1) - j, dir);
                }
            }
        }

        init(board, count + 1);

    }

    private static int[][] execute(int[][] board, int x, int y, int dir) {
        // x--
        if (dir == 0) {
            while (true) {
                int nx = x + dx[dir];
                if (nx >= 0) {
                    if (board[nx][y] == board[x][y] && board[x][y] != 0) {
                        board[nx][y] *= 2;
                        board[x][y] = 0;
                        x += dx[dir];
                        answer = Math.max(board[nx][y], answer);
                    } else if (board[nx][y] == 0) {
                        board[nx][y] = board[x][y];
                        board[x][y] = 0;
                        x += dx[dir];
                        answer = Math.max(board[nx][y], answer);
                    } else if (true) {

                    }
                } else {
                    break;
                }
            }
        }
        // x++
        else if (dir == 1) {
            while (true) {
                int nx = x + dx[dir];
                if (nx < n) {
                    if (board[nx][y] == board[x][y] && board[x][y] != 0) {
                        board[nx][y] *= 2;
                        board[x][y] = 0;
                        x += dx[dir];
                        answer = Math.max(board[nx][y], answer);
                    } else if (board[nx][y] == 0) {
                        board[nx][y] = board[x][y];
                        board[x][y] = 0;
                        x += dx[dir];
                        answer = Math.max(board[nx][y], answer);
                    }
                } else {
                    break;
                }
            }
        }
        // y--
        else if (dir == 2) {
            while (true) {
                int ny = y + dy[dir];
                if (ny >= 0) {
                    if (board[x][ny] == board[x][y] && board[x][ny] != 0) {
                        board[x][ny] *= 2;
                        board[x][y] = 0;
                        y += dy[dir];
                        answer = Math.max(board[x][ny], answer);
                    } else if (board[x][ny] == 0) {
                        board[x][ny] = board[x][y];
                        board[x][y] = 0;
                        y += dy[dir];
                        answer = Math.max(board[x][ny], answer);
                    }
                } else {
                    break;
                }
            }
        }
        // y++
        else if (dir == 3) {
            while (true) {
                int ny = y + dy[dir];
                if (ny < n) {
                    if (board[x][ny] == board[x][y] && board[x][ny] != 0) {
                        board[x][ny] *= 2;
                        board[x][y] = 0;
                        y += dy[dir];
                        answer = Math.max(board[x][ny], answer);
                    } else if (board[x][ny] == 0) {
                        board[x][ny] = board[x][y];
                        board[x][y] = 0;
                        y += dy[dir];
                        answer = Math.max(board[x][ny], answer);
                    }
                } else {
                    break;
                }
            }
        }
        return board;
    }
}
