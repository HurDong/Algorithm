import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> cloth = new HashMap<>();
        for(int i=0;i<clothes.length;i++)
        {
            if(cloth.containsKey(clothes[i][1])){
                cloth.put(clothes[i][1],cloth.get(clothes[i][1])+1);
            }else{
                cloth.put(clothes[i][1],1);
            }
            
        }
        // 1개씩
        for(int value : cloth.values()){
            answer *= (value+1);
        }
        return answer-1;
    }
}