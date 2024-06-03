import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 배열 시간초과가 나므로 입력받은 것에 대해서만 처리.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // list에 구간을 넣으면서 중복되면 최신화를 해주는 식으로
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines.add(new Line(x, y));
        }

        Collections.sort(lines);

        int start = lines.get(0).start;

        int end = lines.get(0).end;

        int length = 0;

        for (Line line : lines) {
            int s = line.start;
            int e = line.end;
            // 긋는 선분이 사이에 있고
            if (s >= start && s <= end) {
                // 더 확장된다면 end만 최신화
                if (e > end) {
                    end = e;
                }
                // 아니라면 아무일도..
            }
            // 선분 밖에 시작한다면
            else {
                // 여태까지의 길이를 length에 추가 후 새로운 선분 추가
                length += end - start;
                start = s;
                end = e;
            }
        }
        length += end - start;
        System.out.println(length);
    }
}

class Line implements Comparable<Line> {
    int start, end;

    Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 시작점 오름차순, 시작점 같으면 끝점 오름차순
    @Override
    public int compareTo(Line o) {
        if (this.start == o.start) {
            return this.end - o.end;
        } else
            return this.start - o.start;
    }
}
