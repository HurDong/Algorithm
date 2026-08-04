class Solution {

    int answer = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        dfs(0, 0, picks, minerals);
        return answer;
    }

    void dfs(int index, int fatigue, int[] picks, String[] minerals) {
        if (index >= minerals.length || picks[0] + picks[1] + picks[2] == 0) {
            answer = Math.min(answer, fatigue);
            return;
        }

        for (int pick = 0; pick < 3; pick++) {
            if (picks[pick] == 0) {
                continue;
            }

            picks[pick]--;

            int sum = 0;

            for (int i = index; i < index + 5 && i < minerals.length; i++) {
                String mineral = minerals[i];

                if (pick == 0) {
                    sum += 1;
                } else if (pick == 1) {
                    sum += mineral.equals("diamond") ? 5 : 1;
                } else {
                    if (mineral.equals("diamond")) {
                        sum += 25;
                    } else if (mineral.equals("iron")) {
                        sum += 5;
                    } else {
                        sum += 1;
                    }
                }
            }

            dfs(index + 5, fatigue + sum, picks, minerals);
            picks[pick]++;
        }
    }
}