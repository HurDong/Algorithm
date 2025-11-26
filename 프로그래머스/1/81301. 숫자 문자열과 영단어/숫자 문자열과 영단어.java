import java.util.*;

class Solution {
    // step 1 : 기본 설정
    String[] numbers = {
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    };
    public int solution(String s) {
        // step 2 : 0~9까지 전체 s에서 각 numbers 배열에 해당하는 문자열 숫자 문자열로 치환
        for(int i=0;i<=9;i++)
        {
            s = s.replace(numbers[i],String.valueOf(i));
        }
        // step 3 : 문자열 s를 정답형인 Integer로 변환
        return Integer.parseInt(s);
    }
}