import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
				
		String[] arr = new String[s];		
		st = new StringTokenizer(bf.readLine());
		arr = st.nextToken().split("");
		
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int numA = 0, numC = 0, numG = 0, numT = 0;
		
		int start = 0, end = p-1, count = 0;
		
		for(int i=0; i<p;i++) {
			if(arr[i].equals("A")) numA++;
			else if(arr[i].equals("C")) numC++;
			else if(arr[i].equals("G")) numG++;
			else numT++;
		}
		
		while(end < s)
		{
//			System.out.println("Start : " + start + " End : " + end);
//			System.out.println("A : " + numA + " C : " + numC + " G : " + numG + " T : " + numT);
			if(numA >= a && numC >= c && numG >= g && numT >= t)
			{
				count++;
			}
			
			if(start == s-1) break;
			
			
			if(arr[start].equals("A")) 
			{
					if(numA>0)
					numA--;
			}
			else if(arr[start].equals("C"))
			{
					if(numC>0)
					numC--;
			}
			else if(arr[start].equals("G"))
			{
				if(numG>0)
				numG--;
			}
			else 
			{
				if(numT>0)
				numT--;
			}

			start++;
			
			
			if(end == s-1) break;
			
			end++;
							
			if(arr[end].equals("A")) numA++;
			else if(arr[end].equals("C")) numC++;
			else if(arr[end].equals("G")) numG++;
			else numT++;
			
		}
		
		
		System.out.println(count);
	}
}
