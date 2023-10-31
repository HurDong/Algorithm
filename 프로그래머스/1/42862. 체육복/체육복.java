class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cloth = new int[n];
        for(int i=0;i<n;i++)
        {
            cloth[i] = 1;
        }
        for(int i=0;i<lost.length;i++)
        {
            cloth[lost[i]-1]--;
        }
        for(int i=0;i<reserve.length;i++)
        {
            cloth[reserve[i]-1]++;
        }
       for(int i = 0; i < n; i++) {
            if(cloth[i] == 0) {
                if(i > 0 && cloth[i - 1] == 2) {
                    cloth[i - 1]--;
                    cloth[i]++;
                } else if(i < n - 1 && cloth[i + 1] == 2) {
                    cloth[i + 1]--;
                    cloth[i]++;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(cloth[i] > 0) {
                answer++;
            }
        }
        return answer;
    }
}