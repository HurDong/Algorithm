import java.util.*;

class Solution {
    public int solution(int[] ingredients) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int ingredient : ingredients){
            stack.add(ingredient);
            int size = stack.size();
            if(size>=4){
                if(stack.get(size-1)==1){
                    if(stack.get(size-2)==3){
                        if(stack.get(size-3)==2){
                            if(stack.get(size-4)==1){
                                for(int i=0;i<4;i++)
                                {
                                    stack.pop();
                                }
                                answer++;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}