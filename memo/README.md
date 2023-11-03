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
2. 소수점 n번째 자리에서 반올림하여 출력
    ```java
    System.out.printf("%.2f\n", sum);
    ```

