import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt(); 
            int y1 = sc.nextInt(); 
            int x2 = sc.nextInt(); 
            int y2 = sc.nextInt(); 
            int n = sc.nextInt(); 

            int count = 0;
            
            for (int j = 0; j < n; j++) {
                int cx = sc.nextInt(); 
                int cy = sc.nextInt(); 
                int r = sc.nextInt(); 

                boolean startInside = isInside(x1, y1, cx, cy, r);
                boolean endInside = isInside(x2, y2, cx, cy, r);

                if (startInside != endInside) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    // 원 안에 점이 있는지 확인하는 함수
    private static boolean isInside(int x, int y, int cx, int cy, int r) {
        int distance = (x - cx) * (x - cx) + (y - cy) * (y - cy);
        return distance < r * r;
    }
}
