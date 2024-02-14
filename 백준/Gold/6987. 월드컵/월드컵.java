import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static List<int[]> worldcup;
	static int isAns = 0;

	static void nextPermutation(int index, int start, int[] ans, List<int[]> comb) {
		if (start == ans.length) {
			int[] temp = new int[ans.length];
			for (int i = 0; i < ans.length; i++) {
				temp[i] = ans[i];
			}
			comb.add(temp);
		} else {
			for (int i = 0; i < 3; i++) {
				if (worldcup.get(index)[i] > 0) {
					worldcup.get(index)[i]--;
					ans[start] = i;
					nextPermutation(index, start + 1, ans, comb);
					worldcup.get(index)[i]++;
				}
			}
		}
	}

	static List<int[]> nextPermutations(int index, int size) {
		List<int[]> comb = new ArrayList<>();
		int[] ans = new int[size];
		nextPermutation(index, 0, ans, comb);
//        for(int j=0;j<comb.size();j++) {
//            int [] tmp = comb.get(j);
//            for(int i=0;i<ans.length;i++) {
//                System.out.print(tmp[i]);
//            }
//            System.out.println();
//        }
		return comb;
	}

	static void isPossible(int index) {
		if (index == 6) {
			isAns = 1;
			return;
		}
		List<int[]> tmp = new ArrayList<>();
		tmp = nextPermutations(index, 5 - index);
//		for (int j = 0; j < tmp.size(); j++) {
//			for (int i = 0; i < tmp.get(j).length; i++) {
//				System.out.print(tmp.get(j)[i] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		for (int num = 0; num < tmp.size(); num++) {
			boolean isPoss = true;
			int[] ans = tmp.get(num);

			for (int i = (index + 1); i < 6; i++) {
				worldcup.get(i)[Math.abs(ans[i - index - 1] - 2)]--;
				isPoss = worldcup.get(i)[Math.abs(ans[i - index - 1] - 2)] < 0 ? false : isPoss;
			}

			if (isPoss)
				isPossible(index + 1);

			for (int i = (index + 1); i < 6; i++) {
				worldcup.get(i)[Math.abs(ans[i - index - 1] - 2)]++;
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		for (int c = 0; c < 4; c++) {
			worldcup = new ArrayList<int[]>();
			boolean isPrint = false;
			st = new StringTokenizer(br.readLine());
			for (int person = 0; person < 6; person++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				if (!isPrint && win + draw + lose != 5)
					isPrint = true;
				worldcup.add(new int[] { win, draw, lose });
			}
			if (isPrint)
				sb.append(0).append(" ");
			else {
				isAns = 0;
				isPossible(0);
				sb.append(isAns).append(" ");
			}
		}
		System.out.println(sb);
	}
}