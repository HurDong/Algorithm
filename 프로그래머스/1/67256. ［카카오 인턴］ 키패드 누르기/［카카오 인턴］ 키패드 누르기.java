import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 1 4 7 은 왼손만 3 6 9 은 오른손만 2 5 8 0 은 가까운 손인데 왼손잡이면 왼손 오른손잡이면 오른손
        int left = 10; // 10 : * / 11 : 0 / 12 : #
        int right = 12;  
        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i]==0) numbers[i] =11;
            if(numbers[i]%3==1){
                answer+="L";
                left = numbers[i];
            } else if(numbers[i]%3==0 && numbers[i]!=0){
                answer+="R";
                right= numbers[i];
            } else{
                int leftDist = getDist(left,numbers[i]);
                int rightDist = getDist(right,numbers[i]);
                if(leftDist<rightDist){
                    answer+="L";
                    left = numbers[i];
                } else if(leftDist>rightDist){
                    answer+="R";
                    right= numbers[i];
                    // 거리가 같으면
                } else{
                    // 왼손잡이일 경우 왼손으로
                    if(hand.equals("left")){
                        answer+="L";
                        left=numbers[i];
                    } else{
                        answer+="R";
                        right=numbers[i];
                    }
                }
            }
        }
        return answer;
    }
    public int getDist(int x,int y){
        if(x==0){
            x=11;
        }
        if(y==0){
            y=11;
        }
        return Math.abs((x-1)/3 - (y-1)/3) +Math.abs((x-1)%3  - (y-1)%3);
    }
}