import java.util.*;

class Solution {
    // 사전
    List<String> dict = new ArrayList<>();
    // 모음들
    char[] vowels = {'A','E','I','O','U'};
    
    public int solution(String target) {
        int answer = 1;
        addDict("",0);
        // dict를 오름차순으로 정렬
        Collections.sort(dict);
        for(String word : dict){
            // 같으면 인덱스 반환
            if(word.equals(target)) return answer;
            answer++; // 인덱스 증가
        }
        // 못 찾을 경우 -1로 반환해주자
        return -1;
    }
    public void addDict(String cur, int depth){
        // 길이가 5를 넘으면 return
        if(depth > 5){
            return;
        }
        // 빈 String이 아니라면 dict에 add
        if(!cur.equals("")) dict.add(cur);
        for(char vowel : vowels){
            // 완전 탐색으로 각각의 vowel을 현재 String에 추가하며 길이 1 증가
            addDict(cur + vowel, depth+1);
        }
    }
}