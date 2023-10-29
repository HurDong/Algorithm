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
        Integer.compare(x, y)
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 6);
        map.put(2, 4);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = map.keySet();
        for (int a : set) {
            System.out.println(a);
        }
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
