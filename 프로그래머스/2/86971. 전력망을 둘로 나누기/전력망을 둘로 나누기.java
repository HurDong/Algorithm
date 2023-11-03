import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 트리구조이므로 하나의 간선을 끊으면 무조건 두개의 전력망으로 나뉨.
        int answer = n;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            list.add(new ArrayList<>()); 
        }
        for(int[] wire : wires){
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }
        for(int[] wire : wires){
            boolean[] visited = new boolean[n+1];
            int count = dfs(list,wire[0],wire[1],visited); // 서브트리의 노드수
            answer = Math.min(answer,Math.abs(n-(2*count))); // 송전탑 개수의 차이(절대값) count 와 n-count의 차이
        }
        return answer;
    }
    public int dfs(List<List<Integer>> list, int start, int remove, boolean[] visited){
        int count=1;
        visited[start] = true;
        // start 인접 노드 순회
        for(int next : list.get(start)){
            // 제거하려는 노드가 아니여야함!
            if(next!=remove&&!visited[next]){
                count+=dfs(list,next,remove,visited);
            }
        }
        return count;
    }
}