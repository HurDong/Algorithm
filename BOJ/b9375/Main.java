package b9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        while (T > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> cloth = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                // getOrDefault : type과 같은 key값이 없으면 default가 0인 값으로 생성
                cloth.put(type, cloth.getOrDefault(type, 0) + 1);
            }
            int result = 1;
            for (int val : cloth.values()) {
                result = result * (val + 1);
            }
            // 아무것도 입지 않는 경우 제외
            sb.append(result - 1 + "\n");
            T--;

        }
        System.out.println(sb.toString());
    }
}
