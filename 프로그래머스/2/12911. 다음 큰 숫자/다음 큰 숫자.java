class Solution {
    public int solution(int n) {
        int answer = n + 1;
		while (Integer.bitCount(n) != Integer.bitCount(answer)) {
			answer++;
		}
        return answer;
    }
}