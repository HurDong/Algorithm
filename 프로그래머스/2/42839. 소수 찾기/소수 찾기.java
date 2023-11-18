import java.util.*;

class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] visited = new boolean[7]; // 최대 7의 길이
    public int solution(String numbers) {
        int answer =0;    
        int n = numbers.length();
        // 1~n자리 수를 뽑는 pickNumber(백트래킹)와 소수인지 판별하는 isPrime(소수판단) 메서드를 구현해야함.
        for(int i=0;i<n;i++)
        {
            pickNumber(numbers,"",i+1);
        }
        for(int i=0;i<list.size();i++)
        {
            if(isPrime(list.get(i))){
                answer++;
            }
        }
        return answer;
    }
    public void pickNumber(String s, String temp, int n){
        if(temp.length() == n){
            int num = Integer.parseInt(temp);
            if(!list.contains(num)){
                list.add(num);
            }
        }
        for(int i=0;i<s.length();i++)
        {
            if(!visited[i]){
                visited[i] = true;
                temp += s.charAt(i);
                pickNumber(s,temp,n);
                visited[i] = false;
                temp = temp.substring(0,temp.length()-1);
            }
        }
    }
    public boolean isPrime(int num){
        if(num<2){
            return false;
        }
        else{
            for(int i=2;i<=Math.sqrt(num);i++)
            {
                if(num%i==0){
                    return false;
                }
            }
        }
        return true;
    }
}