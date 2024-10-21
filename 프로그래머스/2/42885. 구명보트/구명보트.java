import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int n = people.length - 1;
        int min = 0;
        int max = n;
        // 최대 2명 / 최대 무게 존재
        while(min<=max){
            if(people[min] + people[max] <= limit){
                min++;
            }
            max--;
            answer++;
        }
        return answer;
    }
}