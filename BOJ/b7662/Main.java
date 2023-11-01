package b7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if ("I".equals(command)) {
                    minHeap.offer(value);
                    maxHeap.offer(value);
                } else {
                    if (value == 1) {
                        if (!maxHeap.isEmpty()) {
                            int max = maxHeap.poll();
                            minHeap.remove(max);
                        }
                    } else {
                        if (!minHeap.isEmpty()) {
                            int min = minHeap.poll();
                            maxHeap.remove(min);
                        }
                    }
                }
            }

            if (minHeap.isEmpty() || maxHeap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxHeap.poll() + " " + minHeap.poll());
            }
        }
    }
}
