class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int idx = 1; // idx의 범위는 1<=idx<=n
        
        int stIdx = 0; // stIdx의 최댓값은 stations.length-1
        
        int[] temp = new int[stations.length+1];
        
        for(int i=0;i<stations.length;i++)
        {
            temp[i] = stations[i];
        }
        
        temp[stations.length] = 200000001 + w;
        
        stations = new int[temp.length];
        
        for(int i=0;i<stations.length;i++)
        {
            stations[i] = temp[i];
        }
        
        while(idx <= n){
            // 기지국 바운더리 안에 없으면
            if(idx<stations[stIdx]-w){
                if(stIdx == stations.length){
                    break;
                }
                answer++;
                idx = idx+2*w+1;
            }
            // 기지국 바운더리 안에 있으면
            else if(idx>=stations[stIdx]-w && idx<=stations[stIdx] + w){
                idx = stations[stIdx] + w + 1;        
            } 
            // 기지국보다 더 앞에 있으면 stIdx 증가
            else{
                stIdx++;
            }
        }
        // // 그리디하게 가야하므로 가장 왼쪽의 기지국은 w거리만큼 떨어져 있어야함.
        // boolean[] aparts = new boolean[n+1];
        // // 먼저 stations에 대하여 전체 아파트 값을 건들자.
        // for(int i=0;i<stations.length;i++)
        // {
        //     aparts[stations[i]] = true;
        //     for(int j=1;j<=w;j++)
        //     {
        //         if(stations[i] - j > 0){
        //             aparts[stations[i] - j] = true;
        //         }
        //         if(stations[i]+j<=n){
        //             aparts[stations[i] + j] = true;
        //         }
        //     }
        // }
        // // 그리디 하게 해야함
        // int idx = 1;
        // while(idx<=n){
        //     // 이미 데이터 전송 받는 곳이면 pass
        //     if(aparts[idx]){
        //         idx++;
        //         continue;
        //     }
        //     // 기지국 설치로 인한 answer 증가
        //     answer++;
        //     // idx를 기억해야하므로 temp 변수 사용
        //     int temp = idx;
        //     // 전송을 받아야하면 w칸만큼 이동 후 기지국 설치
        //     for(int i=1;i<=w*2;i++)
        //     {
        //         if(temp+i<=n){
        //             idx = temp+i;
        //         } else{
        //             break;       
        //         }
        //     }
        //     // 다음 idx로 출발
        //     idx++;
        // }
        return answer;
    }
}