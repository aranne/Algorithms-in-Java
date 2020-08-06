package DP.Edit_Distance;

public class EditDistance {

    /**
     * 1)删除操作：把a[i]删掉之后a[1~i]和b[1~j]匹配
     *             所以之前要先做到a[1~(i-1)]和b[1~j]匹配
     *             f[i-1][j] + 1
     * 2)插入操作：插入之后a[i]与b[j]完全匹配，所以插入的就是b[j]
     *             那填之前a[1~i]和b[1~(j-1)]匹配
     *             f[i][j-1] + 1
     * 3)替换操作：把a[i]改成b[j]之后想要a[1~i]与b[1~j]匹配
     *             那么修改这一位之前，a[1~(i-1)]应该与b[1~(j-1)]匹配
     *             f[i-1][j-1] + 1
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {        // initialize
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }
}
