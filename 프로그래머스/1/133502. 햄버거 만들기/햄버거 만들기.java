import java.util.*;

class Solution {
    public int solution(int[] ingredients) {
        int answer = 0;
        // Stack을 활용하여 1-2-3-1 연속성 판단
        Stack<Integer> stack = new Stack<>();
        for(int ingredient : ingredients){
            stack.add(ingredient);
            int size = stack.size();
            // stack의 크기가 4이상일때부터 햄버거 만들기 도전
            if(size>=4){
                // 순서대로 맞는 지 확인
                if(stack.get(size-1)==1){
                    if(stack.get(size-2)==3){
                        if(stack.get(size-3)==2){
                            if(stack.get(size-4)==1){
                                // 맞다면 4개의 요소 pop 후 answer 증가
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