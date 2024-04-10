import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // 인덱스를 스택에 저장하여 다음 번 큰 수를 찾기
        stack.push(0); // 맨 앞 원소 넣기
        for(int i=1;i<n;i++)
        {
            // stack이 안 비어있을 때 stack의 tail에 있는 원소가 현재 인덱스 number보다 작다면 tail 원소 answer는 현재 number를 답으로 갖음
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]){
                answer[stack.peek()] = numbers[i];
                stack.pop(); // 다음 stack 원소도 수행
            }
            stack.push(i);
        }
        // 남아 있는 원소는 -1로        
        while(!stack.isEmpty()){
            answer[stack.peek()] = -1;
            stack.pop();
        }
        return answer;
    }
}
// 9 1 3 5 6 2
// 9 1 3 5 6 2
