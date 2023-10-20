import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<s.length();i++)
        {
            if(queue.isEmpty()){
               if(s.charAt(i)=='('){
                   queue.add('(');
               } else{
                   answer = false;
                   break;
               }
            }else{
                if(s.charAt(i)=='('){
                    queue.add('(');
                }else{
                    if(queue.peek()==')'){
                        answer= false;
                        break;
                    }else{
                        queue.poll();
                    }
                }
            }
        }
        if(!queue.isEmpty()){
            answer=false;
        }
        return answer;
    }
}