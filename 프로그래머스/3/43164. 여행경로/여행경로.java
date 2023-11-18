import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String[] ticket : tickets){
            map.putIfAbsent(ticket[0],new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]); // 출발지와 도착지 연결
        }
        Stack<String> stack = new Stack<>(); // 도착지와 그 다음 출발지가 없을 경우를 대비한 자료구조
        stack.push("ICN"); // 최초 출발점 ICN 설정
        while(!stack.isEmpty()){
            String cur = stack.peek();
            if(map.containsKey(cur) && !map.get(cur).isEmpty()){
                stack.push(map.get(cur).poll()); // 다음 출발지로 이동
            } else{
                list.add(0,stack.pop()); // 그 전 도착지로 이동 후 경로에 저장
            }
        }
        return list.toArray(new String[0]);
    }
}