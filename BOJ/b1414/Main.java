package b1414;

import java.util.*;

public class Main {
	static int N; // 컴퓨터의 개수
	static int[][] graph; // 그래프
	static boolean[] visited; // 방문 여부를 저장하는 배열
	static int[] minEdge; // 각 노드에 대한 최소 간선 값

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 컴퓨터의 개수를 입력받음

		graph = new int[N][N]; // 그래프 초기화

		visited = new boolean[N]; // 방문 여부 배열 초기화

		minEdge = new int[N]; // 최소 간선 값 배열 초기화

		int totalLength = 0; // 전체 랜선의 길이
		for (int i = 0; i < N; i++) {
			String line = sc.next(); // 랜선의 길이를 입력받음
			for (int j = 0; j < N; j++) {
				char c = line.charAt(j); // 각 문자를 가져옴
				if (c == '0')
					continue; // 랜선이 없는 경우, 다음 문자로 넘어감
				int length;
				if (c >= 'A' && c <= 'Z') { // 대문자인 경우, 해당하는 숫자로 변환
					length = c - 'A' + 27;
				} else { // 소문자인 경우, 해당하는 숫자로 변환
					length = c - 'a' + 1;
				}

				graph[i][j] = length; // 그래프에 랜선의 길이를 저장

				totalLength += length; // 전체 랜선의 길이를 계산
			}
		}

		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소 간선 값 배열을 fill을 이용하여 최대값으로 채움

		minEdge[0] = 0; // 첫 번째 노드의 최소 간선 값은 0

		int result = 0; // 모든 컴퓨터를 연결하는 데 필요한 최소 랜선의 길이

		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE; // 최소 간선 값
			int minVertex = -1; // 최소 간선 값을 가지는 노드

			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > minEdge[j]) { // 방문하지 않은 노드 중에서 최소 간선 값을 가지는 노드를 찾음
					min = minEdge[j]; // min 보다 작으면 min의 값을 최신화
					minVertex = j; // 해당 인덱스 저장
				}
			}

			if (minVertex == -1) { // 모든 컴퓨터를 연결할 수 없는 경우, -1을 출력하고 종료
				System.out.println(-1);
				return;
			}

			visited[minVertex] = true; // 최소 간선 값을 가지는 노드를 방문했음을 표시

			result += min; // 최소 랜선의 길이를 더함

			for (int j = 0; j < N; j++) {
				if (!visited[j] && graph[minVertex][j] != 0 && minEdge[j] > graph[minVertex][j]) { // 방문하지 않은 노드 중에서
																									// 랜선이연결되어 있고, 현재
																									// 노드를 통해 연결하는 것이 더
																									// 짧은경우, 최소 간선 값을
																									// 업데이트
					minEdge[j] = graph[minVertex][j];
				}
			}
		}

		System.out.println(totalLength / 2 - result); // 기부할 수 있는 랜선의 최대 길이를 출력
	}
}
