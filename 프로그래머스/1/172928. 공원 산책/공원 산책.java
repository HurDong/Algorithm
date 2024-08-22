import java.util.*;

class Solution {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int h, w; // 높이 너비
    public int[] solution(String[] park, String[] routes) {
        h = park.length;
        w = park[0].length();
        int idx = 0;
        boolean isStart = false;
        int[] cur = new int[2];
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            {
                if(park[i].charAt(j)=='S'){
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
        while(idx < routes.length){
            int[] next = move(park,routes[idx],cur);
            cur[0] = next[0];
            cur[1] = next[1];
            idx++;
            System.out.println(idx + " : " + cur[0] + " " + cur[1]);
        }
        int[] answer = new int[2];
        answer[0] = cur[0];
        answer[1] = cur[1];
        return answer;
    }
    public int[] move(String[] park,String route, int[] cur){
        int[] temp = new int[2];
        temp[0] = cur[0];
        temp[1] = cur[1];
        String[] splitRoute = route.split(" ");
        char dirChar = splitRoute[0].charAt(0);
        int dist = splitRoute[1].charAt(0) - '0';
        int dir = -1;
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
        int cnt = 0;
        int[] next = new int[2];
        while(cnt < dist){
            next[0] = temp[0] + dx[dir];
            next[1] = temp[1] + dy[dir];
            // 벽에 걸리는지
            if(next[0]<0 || next[0]>=h || next[1]<0 || next[1] >=w){
                return cur;
            }
            // 장애물에 걸리는 지
            if(park[next[0]].charAt(next[1])=='X'){
                return cur;
            }
            temp[0] = next[0];
            temp[1] = next[1];
            cnt++;
        }
        return temp;
    }
}