import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[2],o2[2]);
                // o1가 o2보다 크면 1, 같으면 0, 작으면 -1
            }
        });
        int[] parent = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] =i; // 자기 자신으로 먼저 초기화
        }
        for(int i=0;i<costs.length;i++)
        {
            int x = costs[i][0];
            int y = costs[i][1];
            int cost = costs[i][2];
            // cycle이 발생하지 않으면 Union 진행
            if(findParent(parent,x)!=findParent(parent,y)){
                unionParent(parent,x,y);
                answer += cost;
            }
        }
        return answer;
    }
    public int findParent(int[] parent,int x){
        if(parent[x]!=x){
            // 자기 자신을 parent으로 갖는 node 찾을 때 까지 진행
            parent[x] = findParent(parent,parent[x]);
        }
        return parent[x];
    }
    public void unionParent(int[] parent,int x, int y){
        x = findParent(parent,x);
        y = findParent(parent,y);
        if(x<y){
            parent[y]=x;
        }else{
            parent[x]=y;
        }
    }
}