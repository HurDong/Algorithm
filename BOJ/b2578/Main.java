package b2578;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 해당 변수가 check 되었는지 빠르게 접근하는 변수
		boolean[][] delete = new boolean[5][5];
		// 빠른 인덱싱을 위한 배열 선언
		List<int[]> coordinate = new ArrayList<>();
		// 0~25 설정
		for (int i = 0; i <= 25; i++) {
			coordinate.add(new int[2]);
		}
		// board 값 설정보다 coordinate에 설정하여 빠르게 인덱스를 통한 위치 접근
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int num = sc.nextInt();
				coordinate.get(num)[0] = i;
				coordinate.get(num)[1] = j;
			}
		}
		// 정답
		int turn = 0;
		// 5*5 이므로 시간초과가 절대 안날 것이라 판단하여 단순 구현으로 가는 것이 좋을 것이라 판단
		while (!chkBoard(delete)) {
			int target = sc.nextInt();
			int x = coordinate.get(target)[0];
			int y = coordinate.get(target)[1];
			delete[x][y] = true;
			turn++;
		}
		System.out.println(turn);
	}

	private static boolean chkBoard(boolean[][] delete) {
		// count가 3이상이면 탈출
		int count = 0;
		// 먼저 가로 세로에 대해 실시
		for (int i = 0; i < 5; i++) {
			// 가로
			boolean chkRow = true;
			// 세로
			boolean chkCol = true;
			for (int j = 0; j < 5; j++) {
				if (!delete[i][j]) {
					chkRow = false;
				}
				if (!delete[j][i]) {
					chkCol = false;
				}
			}
			if (chkRow)
				count++;
			if (chkCol)
				count++;
		}
		// 대각선 두개
		boolean lCross = true;
		boolean rCross = true;
		for (int i = 0; i < 5; i++) {
			// 왼위 -> 우아래
			if (!delete[i][i]) {
				lCross = false;
			}
			// 우위 -> 왼아래
			if (!delete[i][4 - i]) {
				rCross = false;
			}
		}
		if (lCross)
			count++;
		if (rCross)
			count++;
		return count >= 3 ? true : false;
	}
}
