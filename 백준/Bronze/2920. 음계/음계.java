import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] melody = new int[8];
        int dir = 0; // 1이면 asc 2이면 desc 3이면 mix
        for (int i = 0; i < 8; i++) {
            melody[i] = sc.nextInt();
        }
        if (melody[0] > melody[1]) {
            dir = 2;
        } else {
            dir = 1;
        }
        for (int i = 2; i < 8; i++) {
            if (melody[i - 1] > melody[i]) {
                if (dir == 1) {
                    dir = 3;
                    break;
                }
            } else {
                if (dir == 2) {
                    dir = 3;
                    break;
                }
            }
        }
        if (dir == 1) {
            System.out.println("ascending");
        } else if (dir == 2) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
