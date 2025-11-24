import java.util.*;

class Solution {
    public String solution(String s) {
        // step 1 : StringBuilder로 빠르게 String에 char 붙이기
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean isUpper = true; // 처음 글자면 대문자를 사용해야하므로 사용하는 변수
        // step 2 : 모든 글자에 관하여 반복문 실시
        for(int i=0;i<n;i++){
            // step 3 : 문자의 타입에 따른 처리
            char c = s.charAt(i);
            // 공백일 경우 isUpper true 처리 및 공백 추가
            if(c==' '){
                isUpper = true;
                sb.append(' ');
            }
            // 숫자일경우 isUpper false 처리 및 숫자 추가
            else if(c>='0' && c<='9'){
                isUpper = false;
                sb.append(c);
            }
            // 숫자 공백 알파벳 없다는 가정이므로 else
            else{
                // 대문자가 나와야할 자리라면 무조건 대문자로 변환 후 추가
                if(isUpper){
                    sb.append(Character.toUpperCase(c));
                }
                // 아닐 경우 무조건 소문자로 변환 후 추가
                else{
                    sb.append(Character.toLowerCase(c));
                }
                // 대문자 처리든 소문자 처리든 isUpper false 처리
                isUpper = false;
            }
        }
        // step 4 : StringBuilder -> String
        return sb.toString();
    }
}