class Solution {

    private int[] info;
    private int[][] edges;

    private boolean[] visitedState;
    private int answer;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;

        int nodeCount = info.length;
        this.visitedState = new boolean[1 << nodeCount];

        // 0번 루트 노드는 항상 양
        dfs(1, 1, 0);

        return answer;
    }

    /**
     * @param mask  방문한 노드 집합
     * @param sheep 현재 양의 수
     * @param wolf  현재 늑대의 수
     */
    private void dfs(int mask, int sheep, int wolf) {
        // 같은 방문 집합을 이미 탐색한 경우
        if (visitedState[mask]) {
            return;
        }
        visitedState[mask] = true;

        answer = Math.max(answer, sheep);

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            int parentBit = 1 << parent;
            int childBit = 1 << child;

            // 부모를 아직 방문하지 않았다면 자식에게 갈 수 없음
            if ((mask & parentBit) == 0) {
                continue;
            }

            // 이미 방문한 자식
            if ((mask & childBit) != 0) {
                continue;
            }

            int nextSheep = sheep;
            int nextWolf = wolf;

            if (info[child] == 0) {
                nextSheep++;
            } else {
                nextWolf++;
            }

            // 늑대가 양 이상이면 해당 탐색은 불가능
            if (nextWolf >= nextSheep) {
                continue;
            }

            dfs(mask | childBit, nextSheep, nextWolf);
        }
    }
}