import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int n) {
        for(int i = 0 ; i < n ; i++)
        {
            // System.out.println("====" + i + "====" );
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{i,0});
            dfs(1,list,n);
        }
        // (x,y)를 내려가면서 완탐 -> 전의 것과 두 칸이상 차이나야함 visited를 통해 x 좌표 기저 조건 설정
        return answer;
    }
    public void dfs(int count, List<int[]> list , int n){
        if(count == n){
            answer++;
            return;
        }
        for(int i = 0 ; i < n ; i++)
        {
            // System.out.println(i + " " + count + " " + checkDiag(i,count,list,n));
            if(checkDiag(i,count,list,n)){
                list.add(new int[]{i,count});
                dfs(count+1,list,n);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean checkDiag(int x, int y, List<int[]> list, int n){
        for(int[] queen : list){
            int px = queen[0];
            int py = queen[1];
            if(Math.abs(px-x) == Math.abs(py-y) || x == px || y == py){
                return false;
            }
        }
        return true;
    }
}