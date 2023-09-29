package b11729;

import java.util.Scanner;

public class Main {
    static int count =0;
    static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    hanoi(n, '1', '2', '3');
    System.out.println(count);
    System.out.println(sb.toString());
    sc.close();
  }

  public static void hanoi(int n, char from, char aux, char to) {
    if (n == 1) {
      count++;
      sb.append(from + " " + to+"\n");
    } else {
      hanoi(n - 1, from, to, aux);
      sb.append(from + " " + to+"\n");
      count++;
      hanoi(n - 1, aux, from, to);
    }
  }
}
