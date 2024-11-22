package cn.dlpenn.algorithm.optimise.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Matching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // dp[i][j], 代表s的[0, i)是否可以匹配p的[0, j)
        boolean[][] dp = new boolean[m + 1][n + 1];
        // base case
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) != '*') {
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (matches(s, i - 1, p, j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        return dp[m][n];
    }

    public boolean matches(String s, int i, String p, int j) {
        if (i < 0 || j < 0) {
            return false;
        }
        if (p.charAt(j) == '?') {
            return true;
        }

        return s.charAt(i) == p.charAt(j);
    }

}
