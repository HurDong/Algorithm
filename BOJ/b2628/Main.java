package b2628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());

		int l = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> width = new ArrayList<>();

		// 차이 비교를 위한 0과 마지막 가로 정점 추가
		width.add(0);
		width.add(w);

		ArrayList<Integer> length = new ArrayList<>();

		// 차이 비교를 위한 0과 마지막 세로 정점 추가
		length.add(0);
		length.add(l);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int type = Integer.parseInt(st.nextToken());

			// 가로
			if (type == 0) {
				length.add(Integer.parseInt(st.nextToken()));
			}

			// 세로
			else {
				width.add(Integer.parseInt(st.nextToken()));
			}
		}

		// 모든 입력이 완료되면 가로 리스트를 오름차순 정렬
		Collections.sort(width);

		// 세로 정렬
		Collections.sort(length);

		int widthDiff = 0;

		int lengthDiff = 0;

		for (int i = 0; i < width.size() - 1; i++) {
			widthDiff = Math.max(width.get(i + 1) - width.get(i), widthDiff);
		}

		for (int i = 0; i < length.size() - 1; i++) {
			lengthDiff = Math.max(length.get(i + 1) - length.get(i), lengthDiff);
		}

		System.out.println(widthDiff * lengthDiff);
	}
}