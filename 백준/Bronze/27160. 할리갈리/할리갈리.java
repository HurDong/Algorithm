import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 카드 개수
        HashMap<String, Integer> fruitCount = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String fruit = scanner.next(); // 과일 이름
            int count = scanner.nextInt(); // 개수
            
            // HashMap에 과일 개수를 추가
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + count);
        }
        
        // 과일 개수가 5 인 경우 찾기
        boolean isWinning = false;
        for (int count : fruitCount.values()) {
            if (count == 5) {
                isWinning = true;
                break;
            }
        }
        
        System.out.println(isWinning ? "YES" : "NO");
    }
}
