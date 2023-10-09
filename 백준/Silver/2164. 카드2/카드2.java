

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> card = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		for(int i=1;i<=n;i++)
		{
			card.add(i);
		}
		
		count = 1;
		
		while(card.size()>1)
		{
			if(count%2==0)
			{
				int up = card.poll();
				card.add(up);
				count++;
				//System.out.println(up + "가 위로 이동하였습니다.");
			}
			else
			{
				card.poll();
				//System.out.println(card.poll() + "가 삭제 되었습니다.");
				count--;
			}
			
		}
		System.out.println(card.peek());	
	}
}








