

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int amount = sc.nextInt();
		int temp = amount;
		int[] sugar = new int[2];
		sugar[0] = 5;
		sugar[1] = 3;
		
		int tryNum =0;
		tryNum = amount/sugar[1];
		int maxNum =0;
		maxNum = amount/sugar[0];
		for(int i=0;i<tryNum;i++)
		{
			amount = temp;
			count =0;
			amount = amount - maxNum * sugar[0];
			if(amount%sugar[1]==0) {
				count = maxNum + amount/sugar[1];
				break;
			}
			if(maxNum==0) {
				if(amount%sugar[1]!=0) {
					count=-1;
					break;
				}
			}
			maxNum--;
		}
		
		
		
		System.out.println(count);

	}
}
