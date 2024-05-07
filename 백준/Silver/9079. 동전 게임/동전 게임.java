import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            char[][] coins = new char[3][3];
            for (int i = 0; i < 3; i++) {
                String line = br.readLine().replace(" ", "");
                coins[i] = line.toCharArray();
            }
            int result = bfs(coins);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    static int bfs(char[][] coins) {
        String target = "HHHHHHHHH";
        String target2 = "TTTTTTTTT";
        String start = "";
        for (char[] row : coins) {
            start += new String(row);
        }

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> dist = new HashMap<>();
        queue.add(start);
        dist.put(start, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDist = dist.get(current);
            if (current.equals(target) || current.equals(target2)) {
                return currentDist;
            }

            for (int i = 0; i < 3; i++) {
                String next = flip(current, i, true);
                if (!dist.containsKey(next)) {
                    queue.add(next);
                    dist.put(next, currentDist + 1);
                }
                next = flip(current, i, false);
                if (!dist.containsKey(next)) {
                    queue.add(next);
                    dist.put(next, currentDist + 1);
                }
            }
            String next = flipDiagonal(current, true);
            if (!dist.containsKey(next)) {
                queue.add(next);
                dist.put(next, currentDist + 1);
            }
            next = flipDiagonal(current, false);
            if (!dist.containsKey(next)) {
                queue.add(next);
                dist.put(next, currentDist + 1);
            }
        }
        return -1;
    }

    static String flip(String state, int index, boolean isRow) {
        char[] result = state.toCharArray();
        if (isRow) {
            for (int i = 0; i < 3; i++) {
                result[index * 3 + i] = flipCoin(result[index * 3 + i]);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                result[index + 3 * i] = flipCoin(result[index + 3 * i]);
            }
        }
        return new String(result);
    }

    static String flipDiagonal(String state, boolean isMain) {
        char[] result = state.toCharArray();
        if (isMain) {
            for (int i = 0; i < 3; i++) {
                result[i * 4] = flipCoin(result[i * 4]);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                result[2 + 2 * i] = flipCoin(result[2 + 2 * i]);
            }
        }
        return new String(result);
    }

    static char flipCoin(char c) {
        return (c == 'H') ? 'T' : 'H';
    }
}