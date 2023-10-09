import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int save = 0;
	static int saveK;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		saveK = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		MergeSort.mergeSort(arr, 0, arr.length - 1);

		if (save < saveK) {
			System.out.println(-1);
		}
	}

	public static class MergeSort {
		static void merge(int A[], int p, int q, int r) {
			int n1 = q - p + 1;
			int n2 = r - q;

			int L[] = new int[n1];
			int R[] = new int[n2];

			for (int i = 0; i < n1; ++i)
				L[i] = A[p + i];
			for (int j = 0; j < n2; ++j)
				R[j] = A[q + 1 + j];

			int i = 0, j = 0;

			int k = p;
			while (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					A[k] = L[i];
					i++;
				} else {
					A[k] = R[j];
					j++;
				}
				k++;
				save++;
				if (save == saveK) {
					System.out.println(A[k - 1]);
				}
			}

			while (i < n1) {
				A[k] = L[i];
				i++;
				k++;
				save++;
				if (save == saveK) {
					System.out.println(A[k - 1]);
				}
			}

			while (j < n2) {
				A[k] = R[j];
				j++;
				k++;
				save++;
				if (save == saveK) {
					System.out.println(A[k - 1]);
				}
			}
		}

		static void mergeSort(int A[], int p, int r) {
			if (p < r) {
				int q = (p + r) / 2;

				mergeSort(A, p, q);
				mergeSort(A, q + 1, r);

				merge(A, p, q, r);
			}
		}
	}
}
