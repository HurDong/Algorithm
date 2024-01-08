package PGS.p42748;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();
        int T = commands.length;
        int idx = 0;
        while (T-- > 0) {
            int[] arr = new int[commands[idx][1] - commands[idx][0] + 1];
            int arrIdx = 0;
            for (int i = commands[idx][0] - 1; i < commands[idx][1]; i++) {
                arr[arrIdx] = array[i];
                arrIdx++;
            }
            Arrays.sort(arr);
            list.add(arr[commands[idx][2] - 1]);
            idx++;
        }
        System.out.println(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
