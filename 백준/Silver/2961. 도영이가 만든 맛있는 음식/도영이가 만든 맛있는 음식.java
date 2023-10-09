
import java.util.Scanner;

public class Main {

	static int[][] food;
	static int n;
	static int dif;
	static boolean[] visited;
	static int idx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		food = new int[n][2];
		visited = new boolean[n];
		dif = Integer.MAX_VALUE;
		idx = 0;

		for (int i = 0; i < n; i++) {
			food[i][0] = sc.nextInt();
			food[i][1] = sc.nextInt();
		}

		recur(0);

		System.out.println(dif);
	}

	static void recur(int depth) {
		if (depth == n) {
			findDif();
			return;
		}

		visited[depth] = false;
		recur(depth + 1);

		visited[depth] = true;
		recur(depth + 1);

	}

	static void findDif() {
		for (int i = 0; i < n; i++) {
			int s = 1, b = 0;
			if (visited[i] == true) {
				for (int j = 0; j < n; j++) {
					if(visited[j]==true) {
						s = s * food[j][0];
						b = b + food[j][1];						
					}
				}
				if (Math.abs(s - b) < dif) {
					dif = Math.abs(s - b);
				}

			}
		}
	}
}
