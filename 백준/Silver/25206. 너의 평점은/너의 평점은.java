

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		String ap = "A+";
		String a = "A0";
		String bp = "B+";
		String b = "B0";
		String cp = "C+";
		String c = "C0";
		String dp = "D+";
		String d = "D0";
		String p = "P";
		String f = "F";
		int n = 20;
		double grade = 0;
		for (int i = 0; i < 20; i++) {
			String s = sc.next();
			double h = sc.nextDouble();
			String g = sc.next();
			grade= grade + h;
			if (g.equals(ap))
				sum = sum + 4.5 * h;
			else if (g.equals(a))
				sum = sum + 4.0 * h;
			else if (g.equals(bp))
				sum = sum + 3.5 * h;
			else if (g.equals(b))
				sum = sum + 3.0 * h;
			else if (g.equals(cp))
				sum = sum + 2.5 * h;
			else if (g.equals(c))
				sum = sum + 2.0 * h;
			else if (g.equals(dp))
				sum = sum + 1.5 * h;
			else if (g.equals(d))
				sum = sum + 1.0 * h;
			else if (g.equals(f))
				sum = sum + 0.0 * h;
			else {
				n--;
				grade = grade - h;
			}
		}
		System.out.println(sum/grade);
	}
}
