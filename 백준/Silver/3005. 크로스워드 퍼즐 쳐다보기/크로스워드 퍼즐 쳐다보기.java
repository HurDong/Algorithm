import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 단어는 적어도 2글자 이상
        // 왼->오 , 위->아래만 가능
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] cross = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                cross[i][j] = s.charAt(j);
            }
        }
        String answer = "{";
        int x = 0, y = 0;
        // 먼저 가로에 대하여
        while (x < R) {
            while (y < C) {
                if (cross[x][y] != '#') {
                    String temp = "";
                    int i = y;
                    // 다음 #를 만나거나 인덱스의 마지막이 될 때까지 temp에 해당 문자 넣기
                    while (i < C && cross[x][i] != '#') {
                        temp += cross[x][i];
                        i++;
                    }
                    // 단어는 2글자 이상이여야하므로
                    if (temp.length() > 1) {
                        answer = getAnswer(answer, temp);
                    }
                    y = i;
                } else {
                    y++;
                }
            }
            y = 0;
            x++;
        }
        // 다음 세로에 대하여
        while (y < C) {
            while (x < R) {
                if (cross[x][y] != '#') {
                    String temp = "";
                    int i = x;
                    while (i < R && cross[i][y] != '#') {
                        temp += cross[i][y];
                        i++;
                    }
                    if (temp.length() > 1) {
                        answer = getAnswer(answer, temp);
                    }
                    x = i;
                } else {
                    x++;
                }
            }
            x = 0;
            y++;
        }
        System.out.println(answer);
    }

    private static String getAnswer(String answer, String temp) {
        if (answer.length() > 1 && answer.compareTo(temp) < 0) {
            return answer;
        }
        return temp;
    }
}
