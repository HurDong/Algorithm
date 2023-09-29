package b2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    Deque<int[]> deck = new LinkedList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      int number = Integer.parseInt(st.nextToken());
      deck.add(new int[] { i, number });
    }
    int idx = deck.removeFirst()[1];
    sb.append("1 ");
    while (!deck.isEmpty()) {
      //   System.out.println("===" + idx + "===");
      //   for (int[] arr : deck) {
      //     for (int num : arr) {
      //       System.out.print(num + " ");
      //     }
      //     System.out.println();
      //   }
      if (idx > 0) {
        idx= idx%deck.size();
        for (int i = 0; i < idx; i++) {
          deck.addLast(deck.removeFirst());
        }
        idx = deck.peekLast()[1];
        sb.append(deck.removeLast()[0] + " ");
      } else {
        idx = Math.abs(idx);
        for (int i = 0; i < idx; i++) {
          deck.addFirst(deck.removeLast());
        }
        idx = deck.peekFirst()[1];
        sb.append(deck.removeFirst()[0] + " ");
      }
    }
    System.out.println(sb.toString());
  }
}
