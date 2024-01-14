import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] players;
    static int[] scores;
    static boolean[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        players = new int[n];

        scores = new int[1000001];

        cards = new boolean[1000001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < players.length; i++) {
            players[i] = Integer.parseInt(st.nextToken());
            cards[players[i]] = true;
        }

        for (int i : players) {
            // player의 카드만큼 더하면서 cards에 있는 배수만큼 스코어 더하기.
            for (int j = i * 2; j < cards.length; j += i) {
                // 해당 카드에 대해 연산 수행
                if (cards[j]) {
                    scores[i]++;
                    scores[j]--;
                }
            }
        }

        for (int player : players) {
            sb.append(scores[player] + " ");
        }
        System.out.println(sb.toString());
    }

}
