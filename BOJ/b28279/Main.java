package b28279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    Deque<Integer> deck = new LinkedList<>();
    int n = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int inst = Integer.parseInt(st.nextToken());
      switch (inst) {
        case 1:
          int num = Integer.parseInt(st.nextToken());
          deck.addFirst(num);
          break;
        case 2:
          num = Integer.parseInt(st.nextToken());
          deck.addLast(num);
          break;
        case 3:
          if (!deck.isEmpty()) {
            sb.append(deck.removeFirst() + "\n");
          } else {
            sb.append("-1\n");
          }
          break;
        case 4:
          if (!deck.isEmpty()) {
            sb.append(deck.removeLast() + "\n");
          } else {
            sb.append("-1\n");
          }
          break;
        case 5:
          sb.append(deck.size() + "\n");
          break;
        case 6:
          if (deck.isEmpty()) {
            sb.append("1\n");
          } else {
            sb.append("0\n");
          }
          break;
        case 7:
          if (deck.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(deck.peekFirst() + "\n");
          }
          break;
        case 8:
          if (deck.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(deck.peekLast() + "\n");
          }
          break;
      }
    }
    System.out.println(sb.toString());
  }
}
