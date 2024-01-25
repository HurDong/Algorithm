import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long x1, x2, x3, x4, y1, y2, y3, y4;
		x1 = sc.nextLong();
		y1 = sc.nextLong();
		x2 = sc.nextLong();
		y2 = sc.nextLong();
		x3 = sc.nextLong();
		y3 = sc.nextLong();
		x4 = sc.nextLong();
		y4 = sc.nextLong();

		// (x1,y1) - (x2,y2) 선분과 (x3,y3) - (x4,y4) 선분이 만나는 지 만나면 1 안 만나면 0 출력
		// 선분의 기울기 (x1-x2)/(y1-y2)
		long ccw123 = ccw(x1, x2, x3, y1, y2, y3);
		long ccw124 = ccw(x1, x2, x4, y1, y2, y4);
		long ccw341 = ccw(x3, x4, x1, y3, y4, y1);
		long ccw342 = ccw(x3, x4, x2, y3, y4, y2);

		long ccw12 = ccw123 * ccw124;
		long ccw34 = ccw341 * ccw342;

		// 일직선
		if (ccw12 == 0 && ccw34 == 0) {
			// 서로가 서로의 사이에 위치할 때
			if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.max(x1, x2) >= Math.min(x3, x4)
					&& Math.min(y1, y2) <= Math.max(y3, y4) && Math.max(y1, y2) >= Math.min(y3, y4)) {
				System.out.println(1);
			} else
				System.out.println(0);
		}
		// 교차 안함
		else if (ccw12 > 0 || ccw34 > 0) {
			System.out.println(0);
		}
		// 교차함
		else {
			System.out.println(1);
		}
	}

	private static long ccw(long x1, long x2, long x3, long y1, long y2, long y3) {
		long result = (x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x3 * y2 + x2 * y1);
		// ccw * ccw 가 오버플로우 발생하여서 -1 0 1 로 값 간편화
		if (result > 0)
			return 1;
		else if (result == 0)
			return 0;
		else
			return -1;
	}
}