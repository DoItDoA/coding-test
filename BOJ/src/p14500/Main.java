package p14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int n, m;
    private static int max = 0;
    private static int[][] map;
    private static boolean[][] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];
        chk = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[][][] tets = {
                {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
                {{0, 1}, {1, 0}, {1, 1}, {2, 1}},
                {{0, 1}, {1, 0}, {1, 1}, {1, 2}},
                {{0, 0}, {1, 0}, {1, 1}, {2, 0}},
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[][] tet : tets) {
                    int sum = 0;
                    for (int[] p : tet) {
                        int y = p[0] + i;
                        int x = p[1] + j;
                        if (y >= n || x >= m) {
                            sum = 0;
                            break;
                        }
                        sum += map[y][x];
                    }
                    if (max < sum) max = sum;
                }
                chk[i][j] = true;
                dfs(i, j, 0, map[i][j]);
                chk[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void dfs(int y, int x, int depth, int sum) {
        if (depth == 3) {
            if (max < sum) max = sum;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int ny = dy[k] + y;
            int nx = dx[k] + x;

            if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;

            if (!chk[ny][nx]) {
                chk[ny][nx] = true;
                dfs(ny, nx, depth + 1, map[ny][nx] + sum);
                chk[ny][nx] = false;
            }
        }
    }
}
