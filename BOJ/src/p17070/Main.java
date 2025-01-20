package p17070;
// 존나 어려움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] dy = {0, 1, 1};
    private static int[] dx = {1, 0, 1};
    private static int n;
    private static int[][] map;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[3][n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(dfs(0, 1, 0));

    }

    private static int dfs(int y, int x, int direction) {
        if (y == n - 1 && x == n - 1) return 1;
        if (dp[direction][y][x] != 0) return dp[direction][y][x];

        for (int k = 0; k < 3; k++) {
            if (direction == 0 && k == 1) continue;
            if (direction == 1 && k == 0) continue;

            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny >= n || nx >= n) continue;
            if (k != 2 && map[ny][nx] == 1) continue;
            else if (k == 2 && (map[ny][nx] == 1 || map[y][nx] == 1 || map[ny][x] == 1)) continue;
            dp[direction][y][x] += dfs(ny, nx, k);

        }
        return dp[direction][y][x];
    }
}
