import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] party;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        // 진실을 아는 사람이 파티에 있으면 거짓으로 판명
        // 진실을 듣고 다른 파티에서 거짓을 들어도 거짓으로 판명
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        party = new ArrayList[m];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int truthCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < truthCount; i++) {
            int truthPerson = Integer.parseInt(st.nextToken());
            parent[truthPerson] = 0; // 진실을 아는 사람의 값을 0으로 하기로 약속
        }

        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partyCount = Integer.parseInt(st.nextToken());
            int firstPerson = Integer.parseInt(st.nextToken());
            party[i].add(firstPerson); // firstPerson을 기준으로 union 진행

            for (int j = 1; j < partyCount; j++) {
                int person = Integer.parseInt(st.nextToken());
                party[i].add(person);
                union(firstPerson, person);
            }
        }

        for (int i = 0; i < m; i++) {
            if (find(party[i].get(0)) != 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x == 0)
                parent[y] = 0; // 진실을 아는 사람과 연결
            else
                parent[x] = y;
        }
    }
}
