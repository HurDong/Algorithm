package b2564;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int xlen = sc.nextInt();
		int ylen = sc.nextInt();
		int n = sc.nextInt();
		int answer = 0;
		int[][] stores = new int[n][2];
		for (int i = 0; i < n; i++) {
			stores[i][0] = sc.nextInt();
			stores[i][1] = sc.nextInt();
		}
		int dirD = sc.nextInt();
		int placeD = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int dir = stores[i][0];
			int place = stores[i][1];
			// 1 : 북 / 2 : 남 / 3 : 서 / 4 : 동
			if (dir == 1) {
				if (dirD == 1) {
					answer += Math.abs(placeD - place);
				} else if (dirD == 2) {
					answer += ylen + Math.min(place + placeD, (xlen - placeD) + (xlen - place));
				} else if (dirD == 3) {
					answer += place + placeD;
				} else {
					answer += placeD + (xlen - place);
				}
			} else if (dir == 2) {
				if (dirD == 1) {
					answer += ylen + Math.min(place + placeD, (xlen - placeD) + (xlen - place));
				} else if (dirD == 2) {
					answer += Math.abs(placeD - place);
				} else if (dirD == 3) {
					answer += (ylen - placeD) + place;
				} else {
					answer += (ylen - placeD) + (xlen - place);
				}
			} else if (dir == 3) {
				if (dirD == 1) {
					answer += placeD + place;
				} else if (dirD == 2) {
					answer += placeD + (ylen - place);
				} else if (dirD == 3) {
					answer += Math.abs(placeD - place);
				} else {
					answer += xlen + Math.min(placeD + place, (ylen - place) + (ylen - placeD));
				}
			} else {
				if (dirD == 1) {
					answer += (xlen - placeD) + place;
				} else if (dirD == 2) {
					answer += (xlen - placeD) + (ylen - place);
				} else if (dirD == 3) {
					answer += xlen + Math.min(place + placeD, (ylen - place) + (ylen - placeD));
				} else {
					answer += Math.abs(placeD - place);
				}
			}

		}
		System.out.println(answer);
	}
}
