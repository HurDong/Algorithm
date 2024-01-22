package b1339;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 알파벳을 0~9로 치환하여 두 알파벳 스트링의 합을 최대로
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = sc.next();
		}

		// 각 알파벳의 우선순위를 저장할 배열
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				// map에 알파벳의 우선순위가 설정되어있을경우 최신화 아니라면 해당 자릿수만큼 초기화
				map.put(words[i].charAt(j),
						(int) (map.getOrDefault(words[i].charAt(j), 0) + Math.pow(10, words[i].length() - (j + 1))));
			}
		}

		// 우선순위를 비교 후 9부터 부여 해줘야함.
		Integer[] values = new Integer[10];

		// map을 Integer[] 로 변환
		values = map.values().toArray(new Integer[0]);

		// 우선순위의 내림차순으로 정렬
		Arrays.sort(values, (a, b) -> b - a);

		int sum = 0;

		int number = 9;

		// 우선순위가 높은 거부터 9부터 0까지 할당
		for (int value : values) {
			sum += number * value;
			number--;
		}

		System.out.println(sum);
	}
}
