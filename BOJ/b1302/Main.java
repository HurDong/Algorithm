package b1302;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static class Book implements Comparable<Book> {
        String name;
        int sales;

        public Book(String name, int sales) {
            this.name = name;
            this.sales = sales;
        }

        @Override
        public int compareTo(Book o) {
            if (this.sales == o.sales) {
                return this.name.compareTo(o.name); // 사전순으로 정렬
            } else {
                return o.sales - this.sales; // 판매량 내림차순
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        PriorityQueue<Book> pq = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String bookName = sc.nextLine();
            map.put(bookName, map.getOrDefault(bookName, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Book(entry.getKey(), entry.getValue()));
        }
        System.out.println(pq.peek().name);
    }
}
