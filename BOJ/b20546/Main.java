package b20546;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 3일연속 증가-> 다음날 감소 / 감소 -> 증가 : 가정
		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt();

		int[] stocks = new int[15];

		int upDown = 0; // 0이면 전과 동일, 1이면 증가, -1이면 감소

		int continuous = 0; // continuous가 3이면 매수 or 매도

		for (int i = 1; i <= 14; i++) {
			stocks[i] = sc.nextInt();
		}

		int bnpMoney = money;

		int bnpStocks = 0;

		int timingMoney = money;

		int timingStocks = 0;

		// BNP
		for (int i = 1; i <= 14; i++) {
			// 바로 가능하면 전량 매수
			if (money / stocks[i] > 0) {
				bnpStocks += bnpMoney / stocks[i];
				bnpMoney = bnpMoney % stocks[i];
			}
		}

		// TIMING
		for (int i = 2; i <= 14; i++) {
			if (stocks[i] > stocks[i - 1]) {
				if (upDown == 1) {
					continuous++;
					if (continuous >= 3) {
						// 전량 매도
						timingMoney += timingStocks * stocks[i];
						timingStocks = 0;
					}
				} else {
					continuous = 1;
					upDown = 1;
				}
			} else if (stocks[i] < stocks[i - 1]) {
				if (upDown == -1) {
					continuous++;
					if (continuous >= 3) {
						// 전량 매수
						timingStocks += timingMoney / stocks[i];
						timingMoney = timingMoney % stocks[i];
					}
				} else {
					continuous = 1;
					upDown = -1;
				}
			} else {
				continuous = 0;
				upDown = 0;
			}
		}
		
		// 총 재산 계산
		int bnp = bnpMoney + bnpStocks * stocks[14];

		int timing = timingMoney + timingStocks * stocks[14];
		
		// 대소 비교에 따른 결과 출력
		if (bnp > timing) {
			System.out.println("BNP");
		} else if (bnp < timing) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}
	}
}
