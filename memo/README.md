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

[코드 보러가기](https://github.com/HurDong/Algorithm/blob/main/memo/Code/LongestCommonSubstring/LongestCommonSubsequenceLength.java)

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

# 다익스트라 알고리즘

## 알고리즘 설명

- 가중치가 있는 그래프에서 한 정점에서 다른 모든 정점까지의 최단 경로를 찾는 알고리즘.
- 우선순위 큐를 사용하여 현재까지 발견된 가장 짧은 경로를 가진 정점을 빠르게 찾음.
- 각 정점까지의 최단 거리를 저장하는 배열과 해당 정점을 방문했는지 확인하는 배열을 사용.

## 코드

[코드 보러가기](https://github.com/HurDong/Algorithm/blob/main/memo/Code/DijkstraAlgorithm/DijkstraAlgorithm.java)

```java
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) {
        int V = 5; // 정점의 개수
        int[][] graph = new int[][]{
            {0, 10, 0, 0, 5},
            {0, 0, 1, 0, 2},
            {0, 0, 0, 4, 0},
            {7, 0, 6, 0, 0},
            {0, 3, 9, 2, 0}
        };

        int[] dist = dijkstra(V, graph, 0); // 0번 정점에서 시작

        System.out.println("최단 거리: " + Arrays.toString(dist));
    }

    static int[] dijkstra(int V, int[][] graph, int start) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            for (int i = 0; i < V; i++) {
                if (!visited[i] && graph[currentVertex][i] != 0 && dist[i] > dist[currentVertex] + graph[currentVertex][i]) {
                    dist[i] = dist[currentVertex] + graph[currentVertex][i];
                    pq.offer(new Node(i, dist[i]));
                }
            }
        }

        return dist;
    }
}
```

## 코드 설명

- `Node` 클래스는 각 정점과 그 정점까지의 거리를 저장하고, `PriorityQueue`는 현재까지 발견된 가장 짧은 경로를 가진 정점을 빠르게 찾기 위해 사용.
- `dijkstra` 메서드는 주어진 그래프에서 한 정점에서 다른 모든 정점까지의 최단 거리를 계산.
- `dist` 배열은 각 정점까지의 최단 거리를 저장하고, visited 배열은 해당 정점을 방문했는지 확인.
- `PriorityQueue`를 사용하여 현재까지 발견된 가장 짧은 경로를 가진 정점을 빠르게 찾고, 최단 거리 배열을 반환.

# Union Find (유니온 파인드) 알고리즘

## 알고리즘 설명

- 유니온 파인드(`Union Find`)는 그래프의 연결 요소를 효율적으로 찾거나, 두 요소가 같은 그룹에 속하는지 판단하는 알고리즘.
- 주로 노드 간의 연결 상태를 관리하는 데 사용되며, '합집합 찾기' 알고리즘으로도 알려짐.

## 핵심 개념

1. **Union**: 두 집합을 하나로 합치는 연산
2. **Find**: 어떤 요소가 어느 집합에 포함되어 있는지 찾는 연산

## 구현 방법

- 각 요소의 부모 요소를 기록하는 배열을 사용
- 초기에는 각 요소의 부모 요소를 자기 자신으로 설정
- `Find` 연산은 요소의 최상위 부모(루트 노드)를 찾음
- `Union` 연산은 두 요소의 최상위 부모를 찾고, 한쪽의 부모를 다른 쪽의 부모로 설정

## 코드

[코드 보러가기](https://github.com/HurDong/Algorithm/blob/main/memo/Code/UnionAndFindAlgorithm/UnionAndFindAlgorithm.java)

```java
public class UnionFind {

    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 5);

        System.out.println("1과 3이 연결되어 있나요? " + (uf.find(1) == uf.find(3)));
        System.out.println("4와 5가 연결되어 있나요? " + (uf.find(4) == uf.find(5)));
    }
}
```

## 코드 설명

- `UnionFind` 클래스는 집합의 크기를 인자로 받아 각 요소의 부모를 자기 자신으로 초기화
- `find` 메서드는 주어진 요소의 루트 노드를 찾습니다. 루트 노드를 찾는 과정에서 경로 압축(`Path Compression`)을 사용하여 효율성을 높임.
- `union` 메서드는 두 요소를 하나의 집합으로 합칩니다. 이 때, 한 요소의 루트 노드를 다른 요소의 루트 노드의 자식으로 만듦.
- `main` 메서드에서는 예시로 몇 개의 요소를 합치고, 두 요소가 같은 집합에 있는지 확인
