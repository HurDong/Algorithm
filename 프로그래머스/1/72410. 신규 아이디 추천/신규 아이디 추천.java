import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        // .은 처음과 마지막 사용 불가 , 연속 사용 불가
        int len = new_id.length();
        // Step 1
        for(int i=0;i<len;i++)
        {
            char c = new_id.charAt(i);
            if(c>='A' && c<='Z'){
                char newChar = (char) (c + 32);
                new_id = new_id.substring(0, i) + newChar + new_id.substring(i + 1);
            }
        }
        // Step 2
        for(int i=0;i<new_id.length();)
        {
            char c = new_id.charAt(i);
            if((c>='a'&&c<='z')||(c>='0'&&c<='9')||c=='-'||c=='_'||c=='.'){
                i++;
            } else{
                new_id = new_id.substring(0,i) + new_id.substring(i+1);
            }
        }
        // Step 3
        for(int i=0;i<new_id.length()-1;){
            String s = new_id.substring(i,i+2);
            if(s.equals("..")){
                new_id = new_id.substring(0,i) + '.' + new_id.substring(i+2);
            }else{
                i++;
            }
        }
        // Step 4
        if(new_id.charAt(0)=='.'){
            new_id = new_id.substring(1);
        }
        if(new_id.length()>0){
            if(new_id.charAt(new_id.length()-1)=='.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        // Step 5
        if(new_id.length()==0){
            new_id += 'a';
        }
        
        // Step 6
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
        }
        while(true){
            if(new_id.charAt(new_id.length()-1)!='.'){
                break;
            }else{
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        // Step 7
        if(new_id.length()<=2){
            while(new_id.length()<3){
                new_id += new_id.charAt(new_id.length()-1);
            }
        }
        answer = new_id;
        return answer;
    }
}