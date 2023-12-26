import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = line.charAt(j);
            }
        }

        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < N; i++) {
            int rowSpace = 0;
            int colSpace = 0;
            for (int j = 0; j < N; j++) {
                // 가로 체크
                if (room[i][j] == '.') {
                    rowSpace++;
                } else if (rowSpace >= 2) {
                    rowCount++;
                    rowSpace = 0;
                } else {
                    rowSpace = 0;
                }

                // 세로 체크
                if (room[j][i] == '.') {
                    colSpace++;
                } else if (colSpace >= 2) {
                    colCount++;
                    colSpace = 0;
                } else {
                    colSpace = 0;
                }
            }
            if (rowSpace >= 2)
                rowCount++;
            if (colSpace >= 2)
                colCount++;
        }

        System.out.println(rowCount + " " + colCount);
    }
}
