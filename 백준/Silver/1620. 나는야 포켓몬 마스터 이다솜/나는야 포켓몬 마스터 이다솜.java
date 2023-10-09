
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		int m = sc.nextInt();

		String[] poke = new String[n];

		Map<String, Integer> pokeMap = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			poke[i] = sc.next();
			pokeMap.put(poke[i], i);
		}

		for (int i = 0; i < m; i++) {
			String s = sc.next();
			if (isInt(s)) {
				System.out.println(poke[Integer.parseInt(s) - 1]);
			} else {
				System.out.println((pokeMap.get(s)+1));
			}
		}

	}

	private static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
