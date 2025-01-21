package p11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] map, dp;
    private static int[] dy = {0, 1, 1};
    private static int[] dx = {1, 0, 1};
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (i == 0) {
                    if (j == 0) dp[i][j] = map[i][j];
                    else dp[i][j] = map[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = map[i][j] + dp[i - 1][j];
                }
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = map[i][j] + Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
