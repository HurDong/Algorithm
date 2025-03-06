import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        // 스티커 갯수 
        int n = sticker.length;
        // 마지막 점 배제 답
        int firstAns = 0;
        // 마지막 점 배제X 답
        int secondAns =0;
        // 종료 조건1
        if(n==1){
            return sticker[0];
        }
        // 종료 조건2
        if(n==2){
            return Math.max(sticker[0],sticker[1]);
        }
        // 배열 선언
        int[][] arr = new int[n+1][2];
        // 마지막 점 배제
        arr[n-1][0] = sticker[n-2];
        arr[n-1][1] = sticker[n-2];
        // dp 실행1
        for(int i=n-2;i>0;i--){
            arr[i][0] = sticker[i-1];
            arr[i][1] = sticker[i-1];
            if(i+2<=n)
                arr[i][0] += Math.max(arr[i+2][0],arr[i+2][1]);
            if(i+3<=n)
                arr[i][1] += Math.max(arr[i+3][0],arr[i+3][1]);
        }
        // 첫번째 답 갱신
        firstAns = Math.max(Math.max(arr[1][0],arr[1][1]),Math.max(arr[2][0],arr[2][1]));
        // 배열 초기화
        arr = new int[n+1][2];
        // 마지막 점 배제X
        arr[n][0] = sticker[n-1];
        arr[n][1] = sticker[n-1];
        arr[n-1][0] = sticker[n-2];
        arr[n-1][1] = sticker[n-2];
        // dp 실행2
        for(int i=n-2;i>0;i--){
            arr[i][0] = sticker[i-1];
            arr[i][1] = sticker[i-1];
            if(i+2<=n)
                arr[i][0] += Math.max(arr[i+2][0],arr[i+2][1]);
            if(i+3<=n)
                arr[i][1] += Math.max(arr[i+3][0],arr[i+3][1]);
        }
        // 두번째 답 갱신
        secondAns = Math.max(Math.max(arr[2][0],arr[2][1]),Math.max(arr[3][0],arr[3][1]));
        // 최종 답 갱신
        return Math.max(firstAns,secondAns);
    }
}