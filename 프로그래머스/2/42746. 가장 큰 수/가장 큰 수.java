import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String[] nums = new String[n];
        for(int i=0;i<n;i++)
        {
            // String 형식으로 변환
            nums[i] = String.valueOf(numbers[i]);
        }
        // String을 붙여서 대소비교를 통해 가장 큰 값을 창출 할 수 있는 원소를 앞으로 보냄
        Arrays.sort(nums,(a,b)->{
            return (b+a).compareTo(a+b);
        });
        String answer = "";
        // 모든 입력이 0일때 0...0이 아닌 0을 출력해야함....
        if(nums[0].equals("0")) return "0"; 
        for(int i=0;i<n;i++)
        {
            answer += nums[i];
        }
        return answer;
    }
}