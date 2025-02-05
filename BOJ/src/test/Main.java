package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, m;
    private static char[][] map;
    private static boolean[][] chk;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][n + 1];
        final int INF = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = Math.min(dp[a][b], c);
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (dp[start][mid] != INF && dp[mid][end] != INF) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid][end]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int num = dp[i][j];
                sb.append(num == INF ? 0 : num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());

    }

//    private static void bfs(int x, int y) {
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{x, y, 1});
//        chk[x][y] = true;
//
//        int max = 1;
//        while (!q.isEmpty()) {
//            int[] p = q.poll();
//
//            if (p[2] > max) max = p[2];
//
//            for (int k = 0; k < 4; k++) {
//                int nx = p[0] + dx[k];
//                int ny = p[1] + dy[k];
//
//                if (nx >= n || nx < 0 || ny >= m || ny < 0 || chk[nx][ny]) continue;
//
//                if (map[nx][ny] == 1) {
//                    chk[nx][ny] = true;
//                    q.add(new int[]{nx, ny, p[2] + 1});
//                }
//            }
//        }
//    }
}