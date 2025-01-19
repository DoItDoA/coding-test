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
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int y, int x) {
        if (y == n - 1 && x == m - 1) return map[y][x];
        if (dp[y][x] != 0) return dp[y][x];

        for (int k = 0; k < 3; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny >= n || nx >= m) continue;

            dp[y][x] = Math.max(dfs(ny, nx) + map[y][x], dp[y][x]);
        }
        return dp[y][x];
    }
}
