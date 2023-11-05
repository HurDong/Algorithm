public class LongestCommonSubsequenceLength {

    public static int findLongestCommonSubsequenceLength(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int[][] dp = new int[aLength + 1][bLength + 1];

        // LCS 길이 계산
        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[aLength][bLength];
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "acdfe";
        System.out.println(findLongestCommonSubsequenceLength(a, b)); // 3
    }
}
