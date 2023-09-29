package b2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] sudoku;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    sudoku = new int[9][9];
    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        sudoku[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    draw(0, 0);
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(sudoku[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void draw(int x, int y) {
    if (x == 9) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          System.out.print(sudoku[i][j] + " ");
        }
        System.out.println();
      }
      System.exit(0);
    }
    // (x,y)의 값이 0일 경우 상하 좌우 3*3을 순회하며 sudoku값 구하기.
    if (sudoku[x][y] == 0) {
      for (int i = 1; i <= 9; i++) {
        if (isValid(x, y, i)) {
          sudoku[x][y] = i;
          draw(x + (y + 1) / 9, (y + 1) % 9);
          sudoku[x][y] = 0;
        }
      }
    } else {
      draw(x + (y + 1) / 9, (y + 1) % 9);
    }
  }

  private static boolean isValid(int x, int y, int idx) {
    for (int i = 0; i < 9; i++) {
      if (
        sudoku[x][i] == idx ||
        sudoku[i][y] == idx ||
        sudoku[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3] == idx
      ) {
        return false;
      }
    }
    return true;
  }
}
