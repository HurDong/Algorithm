import java.util.*;

class Solution {
    // 방향 벡터
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    // 높이 너비
    static int h, w; 
    public int[] solution(String[] park, String[] routes) {
        h = park.length;
        
        w = park[0].length();
        
        int idx = 0;
        // 시작 지점 찾기 위한 변수
        boolean isStart = false; 
        // 시작 지점 배열 -> x,y보다 밑에 좌표 반환 메서드에서 활용 용이
        int[] cur = new int[2];
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            {
                // 시작 지점 찾으면
                if(park[i].charAt(j)=='S'){
                    // 찾았다고 알리고 변수 할당
                    isStart = true;
                    cur[0] = i;
                    cur[1] = j;
                    break;
                }
            }
            if(isStart){
                break;
            }
        }
        // 명령어 수만큼 수행
        while(idx < routes.length){
            // 이동 수행
            cur = move(park,routes[idx],cur);
            // 다음 명령어로 이동
            idx++;
        }
        // 정답 배열 선언
        return new int[]{cur[0],cur[1]};
    }
    // 이동 메서드
    public int[] move(String[] park,String route, int[] cur){
        // 임시 배열
        int[] temp = new int[2];
        // 깊은 복사
        temp[0] = cur[0];
        temp[1] = cur[1];
        // 띄어쓰기 기준으로 String 나누기
        String[] splitRoute = route.split(" ");
        // 방향(char)
        char dirChar = splitRoute[0].charAt(0);
        // 거리
        int dist = splitRoute[1].charAt(0) - '0';
        // 방향
        int dir = -1;
        // dirChar 값에 따라 방향 실제 설정
        switch(dirChar){
            case 'E' :
                dir = 3;
                break;
            case 'N':
                dir = 0;
                break;
            case 'S' :
                dir=  1;
                break;
            case 'W':
                dir =2;
                break;
            default: break;
        }
        // 거리 저장
        int cnt = 0;
        // 거리 1만큼 움직일 때의 다음 좌표
        int[] next = new int[2];
        while(cnt < dist){
            // 다음 좌표 설정
            next[0] = temp[0] + dx[dir];
            next[1] = temp[1] + dy[dir];
            // 벽에 걸리는지
            if(next[0]<0 || next[0]>=h || next[1]<0 || next[1] >=w){
                temp = cur;
                break;
            }
            // 장애물에 걸리는 지
            if(park[next[0]].charAt(next[1])=='X'){
                temp = cur;
                break;
            }
            // 그 어느 조건도 만족하지 않으면 다음 좌표로 이동            
            temp[0] = next[0];
            temp[1] = next[1];
            // 거리 증가
            cnt++;
        }
        return temp;
    }
}