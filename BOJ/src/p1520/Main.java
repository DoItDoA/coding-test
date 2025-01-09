package p1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 어려움

public class Main {
    private static int[][] map, dp;
    private static int n, m;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        dp = new int[n][m];

        for (int y = 0; y < n; y++) {
            String[] val = br.readLine().split(" ");
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(val[x]);
                dp[y][x] = -1;
            }
        }

        int dfs = dfs(0, 0);
        System.out.println(dfs);
    }

    static int dfs(int y, int x) {
        if (y == n - 1 && x == m - 1)
            return 1;
        if (dp[y][x] != -1)
           return dp[y][x];

        dp[y][x] = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (map[ny][nx] < map[y][x]) {
                    dp[y][x] += dfs(ny, nx);
                }
            }
        }
        return dp[y][x];
    }
}
