class Solution {
    public static boolean[] visited;
    public static int bestWay = 0;
    public int solution(int k, int[][] dungeons) {
        // 최소 피로도와 소모 피로도 존재 -> 던전 최대로
        visited = new boolean[dungeons.length];
        bruteForce(k,dungeons,0);
        return bestWay;
    }
    public void bruteForce(int hp, int[][] arr,int ways){
        bestWay = Math.max(bestWay,ways);
        for(int i=0;i<arr.length;i++)
        {
            // 방문 안했고
            if(!visited[i]){
                // 최소 피로도를 만족한다면
                if(hp>=arr[i][0]){
                    visited[i] = true;
                    bruteForce(hp-arr[i][1],arr,ways+1);
                    visited[i] = false;
                }
            }
        }
    }
}