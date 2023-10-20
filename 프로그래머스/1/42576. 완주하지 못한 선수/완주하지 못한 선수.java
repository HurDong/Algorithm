import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> part = new HashMap<>();
        for(int i=0;i<participant.length;i++)
        {
            if(part.containsKey(participant[i])){
                part.put(participant[i],part.get(participant[i])+1);
            }else{
                part.put(participant[i],1);
            }
        }
        for(int i=0;i<completion.length;i++)
        {
            if(part.get(completion[i])>1){
                part.put(completion[i],part.get(completion[i])-1);
            }else{
                part.remove(completion[i]);
            }
        }
        for(String key : part.keySet()){
            answer = key;
            break;
        }
        return answer;
    }
}