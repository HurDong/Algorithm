import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (map.isEmpty()) {
                    sb.append("0\n");
                } else {
                    int key = map.firstKey();
                    PriorityQueue<Integer> queue = map.get(key);
                    int value = queue.poll();
                    if (queue.isEmpty()) {
                        map.remove(key); // queue가 비어있으면 해당 queue를 삭제
                    }
                    sb.append(value + "\n");
                }
            } else {
                int absNum = Math.abs(num);
                map.putIfAbsent(absNum, new PriorityQueue<>()); // 연결된 value가 없을 경우, 새로운 queue를 생성
                map.get(absNum).add(num);
            }
        }
        System.out.println(sb.toString());
    }
}
