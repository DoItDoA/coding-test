package bfs_dfs.level3;

// 등굣길
public class Main6 {
    public static void main(String[] args) {
        int solution = Solution.solution(4, 3, new int[][]{{2, 2}});
        System.out.println(solution);
    }

    private static class Solution {
        private static int[] dy = {0, 1};
        private static int[] dx = {1, 0};
        private static int[][] dp;
        private static int M, N;
        private static int mod = 1_000_000_007;

        public static int solution(int m, int n, int[][] puddles) {
            M = m;
            N = n;
            dp = new int[n][m];

            for (int[] p : puddles) {
                dp[p[1] - 1][p[0] - 1] = -1;
            }

            return dfs(0, 0);

        }

        private static int dfs(int y, int x) {
            if (x == M - 1 && y == N - 1) {
                return 1;
            }

            if (dp[y][x] > 0) {
                return dp[y][x] % mod;
            }

            for (int k = 0; k < 2; k++) {
                int nx = dx[k] + x;
                int ny = dy[k] + y;
                if (nx < M && ny < N) {
                    if (dp[ny][nx] >= 0) {
                        dp[y][x] = (dp[y][x] + dfs(ny, nx)) % mod;
                    }
                }
            }
            return dp[y][x] % mod;
        }
    }
}
