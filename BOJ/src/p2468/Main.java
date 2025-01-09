package p2468;

import java.io.*;

public class Main {
    public static int[][] map;
    public static boolean[][] chk;
    public static int max, n;
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        chk = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(s[j]);
                map[i][j] = num;
            }
        }

        for (int w = 0; w <= 100; w++) {
            int[][] city = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    city[i][j] = map[i][j];
                    if (city[i][j] <= w)
                        city[i][j] = 0;
                }
            }

            chk = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (city[i][j] != 0 && !chk[i][j]) {
                        cnt++;
                        chk[i][j] = true;
                        dfs(i, j, city);
                    }
                }
            }
            if (cnt > max) max = cnt;
        }
        System.out.println(max);
    }

    static void dfs(int y, int x, int[][] city) {
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                if (city[ny][nx] != 0 && !chk[ny][nx]) {
                    chk[ny][nx] = true;
                    dfs(ny, nx, city);
                }
            }
        }
    }
}