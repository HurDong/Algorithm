import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin,target,words,0);
        boolean noTarget = true;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                noTarget = false;
            }
        }
        if(noTarget){
            return 0;
        }else {
            return answer;
        }
    }
    public void dfs(String begin, String target, String[] words, int count){
        if(begin.equals(target)){
            answer = Math.min(count,answer);
            return;
        }
        for(int i=0;i<words.length;i++)
        {
            if(!visited[i]){
                int same =0;
                for(int j=0;j<begin.length();j++)
                {
                    // begin과 words[i]의 같은 알파벳 몇개인지 카운팅
                    if(begin.charAt(j) == words[i].charAt(j)){
                        same++;
                    }
                }
                if(same==begin.length()-1){ // 한번에 최대 한 개만 바꿀 수 있으므로 한개차이만 생각.
                    visited[i] = true;
                    dfs(words[i],target,words,count+1);
                    visited[i] = false;
                }
            }
        }
    }
}