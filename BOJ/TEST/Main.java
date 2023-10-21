package TEST;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] maps = new int[10][10];
        int x = maps.length;
        int y = maps[2].length;
        System.out.println(x + "  " + y);
        int[] arr = { 1, 3, 2, 5, 4 };
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(4);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = map.keySet();
        String s = "asdf";
        PriorityQueue<Integer> que = new PriorityQueue<>();
        queue.add(null);
        switch (s) {
            case "asdf":
                break;
            case "asde":
                break;
            default:
                break;
        }
    }
}
