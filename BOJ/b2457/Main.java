package b2457;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1. 3월 1일 ~ 11월 30일까지 매일 매일 프로젝트 참여
		// 2. 프로젝트 수 가능한 적게 -> 가능한 프로젝트 기간이 긴 프로젝트 선택
		// 저 기간 외에는 프로젝트 진행 안해도 됨, 또한 필요시 프로젝트 2개 이상 진행 가능
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int answer = 0;

		// 3월 1일 이전 시작 하는 프로젝트는 생각X
		ArrayList<int[]> projects = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 시작 월 일
			int startM = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			// 종료 월 일
			int endM = Integer.parseInt(st.nextToken());
			int endD = Integer.parseInt(st.nextToken());
			if (startM * 100 + startD < 1201 && endM * 100 + endD >= 301) {
				projects.add(new int[] { startM * 100 + startD, endM * 100 + endD });
			}
		}

		// projects 시작일 오름차순, 종료일 내림차순으로 정렬
		Collections.sort(projects, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if (arr1[0] == arr2[0])
					return arr2[1] - arr1[1];
				else
					return arr1[0] - arr2[0];
			}
		});

		// 아무것도 없는 경우 0 출력 후 return
		if (projects.isEmpty()) {
			System.out.println(0);
			return;
		}

		int target = 301;

		int max = 0;

		int idx = 0;

		while (target < 1201) {
			max = 0;
			boolean isFind = false;
			// 마지막 업무보다 시작일이 작고 종료일이 큰 것 중에서 가장 종료일이 큰 것 가져오기.
			for (int i = idx; i < projects.size(); i++) {
				int start = projects.get(i)[0];
				int end = projects.get(i)[1];
				if (target >= start) {
					if (max < end) {
						max = end;
						idx = i + 1;
						isFind = true;
					}
				} else {
					break;
				}
			}
			if (isFind) {
				answer++;
				target = max;
			} else {
				break;
			}
		}
		// max가 1131이하인 경우 문제의 조건을 만족 못하므로 0을 출력 아니라면 answer 출력
		System.out.println(max < 1201 ? 0 : answer);
	}
}
