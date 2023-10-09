

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int dif = sc.nextInt();
		int time = h * 60 + m;
		int finalTime = time + dif;
		int finalHour = finalTime/60;
		int finalMin = finalTime - finalHour * 60; 
		if(finalHour>=24) finalHour = finalHour - 24;
		System.out.println(finalHour + " " + finalMin);
		
	}
}
