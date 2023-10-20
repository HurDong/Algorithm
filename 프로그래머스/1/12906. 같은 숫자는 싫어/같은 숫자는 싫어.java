import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int prev=arr[0];
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==prev){
                
            }
            else{
                list.add(arr[i]);
                prev = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            answer[i] = list.get(i);
        }
        return answer;
    }
}