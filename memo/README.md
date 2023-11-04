# 크루스칼 알고리즘
1. 간선을 연결비용에 따라 오름차순 정렬
    ```java
    Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
    ```
2. 순차적으로 순회하며 사이클이 없는 경우 간선의 양 끝점을 Union
3. Parent는 항상 작은 노드 번호를 따름
4. 최상위 Parent를 찾아 해당 노드를 Parent로 설정
5. 모든 간선에 대해 작업을 수행하고 최소 신장 트리 완성 후 최소 비용 반환

# 소수 n번째 자리 표현
1. 두 int를 나누어 double 값으로 변환
    ```java
    double sum = (double) a / b;
    ```
2. 소수점 3번째 자리에서 반올림하여 출력
    ```java
    System.out.printf("%.2f\n", sum);
    ```
# 가장 긴 공통 부분 수열 (한 문자 변경 가능)

## 문제 설명

- 두 문자열 `a`와 `b`가 주어졌을 때, `a`의 임의의 문자 하나를 다른 문자로 변경할 수 있는 조건 하에 두 문자열 간의 가장 긴 공통 부분 수열(Longest Common Subsequence, LCS)의 길이를 찾는 문제

## 코드

```java
public class LongestCommonSubsequenceWithOneChange {

    public static int findLongestCommonSubsequenceLength(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int[][][] dp = new int[aLength + 1][bLength + 1][2];

        // LCS 길이 계산
        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                // 문자 변경 없이 LCS 계산
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
                }

                // 한 문자 변경을 고려하여 LCS 계산
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][1] + 1, // 문자 변경 없이
                                       Math.max(dp[i - 1][j][1], dp[i][j - 1][1])); // 문자 변경
                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j - 1][0] + 1); // 한 문자 변경
                }
            }
        }

        return Math.max(dp[aLength][bLength][0], dp[aLength][bLength][1]);
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "ace";
        System.out.println(findLongestCommonSubsequenceLength(a, b)); // 3
    }
}
```
## 코드 설명
- 이 코드는 동적 프로그래밍을 사용하여 두 문자열 a와 b 사이의 가장 긴 공통 부분 수열의 길이를 계산
- dp[i][j][k] 배열은 문자열 a의 첫 i개 문자와 문자열 b의 첫 j개 문자 사이의 LCS의 길이를 나타내며, k는 문자열 a에서 변경할 수 있는 문자의 수를 나타냄.
- k가 0이면 변경 없이 계산된 LCS의 길이를, 1이면 한 문자 변경을 고려한 LCS의 길이를 나타냄.
- 최종 결과는 dp[aLength][bLength][0]과 dp[aLength][bLength][1] 중 더 큰 값!
