package b20056;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static class Fire {
		int x, y, m, s, d;

		public Fire(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Fire [x=" + x + ", y=" + y + ", m=" + m + ", d=" + d + ", s=" + s + "]";
		}

	}

	// 방향
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static ArrayList<Fire> fires = new ArrayList<>();
	static int n, m, k;
	static int[][] grid;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 격자 크기(1열과 n열은 이어져있다.)
		m = sc.nextInt(); // 파이어 볼의 수
		k = sc.nextInt(); // 명령 수

		grid = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			fires.add(new Fire(x, y, w, s, d));
			grid[x][y] = w; // grid[][] = w : 질량이 w인 파이어볼 위치
		}

		int answer = 0;

		while (k-- > 0) {
			ArrayList<Fire>[][] fireMap = new ArrayList[n + 1][n + 1]; // 각 좌표마다 fire에 대한 정보를 저장
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					fireMap[i][j] = new ArrayList<>();
				}
			}
			// d 방향으로 s칸 만큼 이동 -> 범위 벗어나면 처리
			for (Fire fire : fires) {
				// 속도를 n으로 나눈 나머지만큼 이동
				int x = fire.x + dx[fire.d] * (fire.s % n);
				int y = fire.y + dy[fire.d] * (fire.s % n);

				// 격자 범위를 넘어갔을 때 위치 조정
				x = ((x - 1 + n) % n) + 1;
				y = ((y - 1 + n) % n) + 1;

				fire.x = x;
				fire.y = y;

				fireMap[fire.x][fire.y].add(fire);
			}

			// 이동이 끝난 후 파이어볼이 2개 이상이면 처리
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// 파이어볼 4개로 나눔(위치는 그대로) -> 질량, 속력, 방향 처리
					if (fireMap[i][j].size() >= 2) {
						int w = 0;
						int s = 0;
						for (Fire fire : fireMap[i][j]) {
							w += fire.m;
							s += fire.s;
							fires.remove(fire);
						}
						w /= 5;
						s /= fireMap[i][j].size();
						// 모두 짝수거나 홀수면 방향이 0 2 4 6
						// 아니라면 1 3 5 7
						// 질량이 0보다 커야 생성 가능
						if (w > 0) {
							if (isAllSame(fireMap[i][j])) {
								for (int k = 0; k < 4; k++) {
									fires.add(new Fire(i, j, w, s, k * 2));
								}
							} else {
								for (int k = 0; k < 4; k++) {
									fires.add(new Fire(i, j, w, s, k * 2 + 1));
								}
							}
						}
					}
				}
			}
		}

		// fires 배열에서 파이어볼을 answer에 더해줌
		for (Fire fire : fires) {
			answer += fire.m;
		}

		System.out.println(answer);

	}

	// 모두 짝수인지 모두 홀수인지 -> true
	private static boolean isAllSame(ArrayList<Fire> map) {
		boolean isOdd = false;
		if (map.get(0).d % 2 == 0) {
			isOdd = false;
		} else {
			isOdd = true;
		}
		for (int i = 1; i < map.size(); i++) {
			// 홀수일 경우
			if (isOdd) {
				// 짝수면 false 리턴
				if (map.get(i).d % 2 == 0) {
					return false;
				}
				// 짝수면
			} else {
				if (map.get(i).d % 2 == 1) {
					return false;
				}
			}
		}
		return true;
	}

	// 디버깅용
	private static void print() {
		for (Fire fire : fires) {
			System.out.println(fire.toString());
		}
	}
}
