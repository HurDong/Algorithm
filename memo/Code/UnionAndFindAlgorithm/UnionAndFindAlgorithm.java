package memo.Code.UnionAndFindAlgorithm;

public class UnionAndFindAlgorithm {
    public static int[] parent;

    public static void main(String[] args) {
        int n = 5;
        parent = new int[n + 1];
        // 부모 노드 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        // 예시 데이터
        union(1, 2);
        union(1, 3);
        union(4, 5);
        // 출력
        unionPrint();
    }

    private static void unionPrint() {
        System.out.print("[ ");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println("]");
    }

    public static boolean union(int x, int y) {
        x = find(x); // x의 부모노드 find
        y = find(y); // y의 부모노드 find

        // 같은 그래프 안에 속해 있으면 false
        if (x == y) {
            return false;
        } else if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
        return true;
    }

    private static int find(int x) {
        // 자기 자신을 parent로 가지지 않는다면 parse
        if (parent[x] == x)
            return x;
        return find(parent[x]);
    }
}
