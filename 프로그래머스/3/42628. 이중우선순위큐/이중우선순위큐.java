import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] parts = operation.split(" "); // command와 value를 저장
            String command = parts[0]; // I or D 저장
            int value = Integer.parseInt(parts[1]); // value 값을 저장
            
            if (command.equals("I")) {
                minHeap.offer(value);
                maxHeap.offer(value);
            } else if (command.equals("D")) {
                if (!minHeap.isEmpty()) {
                    if (value == 1) { // 최댓값 삭제
                        int max = maxHeap.poll();
                        minHeap.remove(max);
                    } else { // 최솟값 삭제
                        int min = minHeap.poll();
                        maxHeap.remove(min);
                    }
                }
            }
        }
        
        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}