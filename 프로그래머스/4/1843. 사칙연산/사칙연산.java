import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length;
        // dpMin[i][j] : i부터 j까지 최솟값
        // dpMax[i][j] : i부터 j까지 최댓값
        int[][] dpMin = new int[n][n];
        int[][] dpMax = new int[n][n];
        // 2씩 증가 연산자 제외
        for(int i=0;i<n;i+=2)
        {
            dpMin[i][i] = Integer.parseInt(arr[i]); 
            dpMax[i][i] = Integer.parseInt(arr[i]);
        }
        // i부터 i+len만큼의 부분 수열?의 최댓값과 최솟값을 DP를 활용하여 구하기
        for(int len = 2; len<n;len+=2){
            for(int i=0;i+len<n;i+=2){
                // 끝 인덱스 설정
                int end = i + len;
                // 초기값 세팅
                dpMin[i][end] = Integer.MAX_VALUE;
                dpMax[i][end] = Integer.MIN_VALUE;
                // 연산자에 따른 dp 값 최신화
                for(int j=i+1;j<end;j+=2){
                    // 현재 연산자 가져오기
                    char op = arr[j].charAt(0);
                    // 덧셈이면
                    if(op=='+'){
                        dpMin[i][end] = Math.min(dpMin[i][end],dpMin[i][j-1] + dpMin[j+1][end]);
                        dpMax[i][end] = Math.max(dpMax[i][end],dpMax[i][j-1] + dpMax[j+1][end]);
                    }
                    // 뺄셈이면
                    else if(op=='-'){
                        dpMin[i][end] = Math.min(dpMin[i][end],dpMin[i][j-1] - dpMax[j+1][end]);
                        dpMax[i][end] = Math.max(dpMax[i][end],dpMax[i][j-1] - dpMin[j+1][end]);
                    }
                }
            }
        }
        // 처음부터 끝일때의 최댓값 반환
        return dpMax[0][n-1];
    }
}