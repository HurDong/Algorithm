import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>(); // 범위가 -int ~ +int 까지 이므로 배열은 안되고빈도수를 체크해야하므로 map사용

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1); // 없으면 0을 가져와서 1더함 아니라면 기존 값에서 1더함
        }

        int maxCount = 0;

        long maxCardNum = 0;
        // entryset을 이용하여서 각각의 value를 체크
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            // 더 큰 value면 닶 최신화
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxCardNum = entry.getKey();
            }
            // 같으면 작은 값을 저장
            else if (entry.getValue() == maxCount) {
                if (maxCardNum > entry.getKey()) {
                    maxCardNum = entry.getKey();
                }
            }
        }
        System.out.println(maxCardNum);
    }
}
