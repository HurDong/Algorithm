import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if ("I".equals(command)) {
                    // value가 key값으로 있으면 value값을 1증가 없으면 1로 설정
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else {
                    if (!map.isEmpty()) {
                        int key;
                        if (value == 1) {
                            key = map.lastKey();
                        } else {
                            key = map.firstKey();
                        }
                        if (map.put(key, map.get(key) - 1) == 1) {
                            map.remove(key); // count값이 0이되면 삭제
                        }
                    }
                }

            }
            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}