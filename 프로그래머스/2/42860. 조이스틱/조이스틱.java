class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int min = n-1; // 최소 좌우 이동
        for(int i=0;i<n;i++){
            char c = name.charAt(i);
            // 상하 조작 계산
            answer += Math.min(c-'A',26-(c-'A'));
            // A가 아닌 다른 문자 찾기
            int next = i+1;
            while(next < n && name.charAt(next)=='A'){
                next++;
            }
            // 좌우 조작 계산
            // Math.min(i,n-next) -> 정방향으로 가는 것과 반대방향으로 가는 것 중 최소
            // i : 처음으로 돌아가는 횟수 / n - next : 뒤로 돌아가서 next로 가는 횟수
            min = Math.min(min,i+n-next+Math.min(i,n-next));
        }
        answer+=min;
        return answer;
    }
}