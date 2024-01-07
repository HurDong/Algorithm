package b1043;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 진실을 아는 사람이 파티에 있으면 거짓으로 판명
        // 진실을 듣고 다른 파티에서 거짓을 들어도 거짓으로 판명
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ppl = sc.nextInt();
        int[] truth = new int[ppl];
        if (ppl > 0) {
            for (int i = 0; i < ppl; i++) {
                truth[i] = sc.nextInt();
            }
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int partyLen = sc.nextInt();
            int[] parties = new int[partyLen];
            for (int j = 0; j < partyLen; j++) {
                parties[j] = sc.nextInt();
            }
            list.add(parties);
        }
    }
}
