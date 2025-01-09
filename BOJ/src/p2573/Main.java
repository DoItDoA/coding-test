package p2573;

import java.io.*;

public class Main {
    private static int[][] map, melt;
    private static boolean[][] chk;
    private static int n, m;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int cnt, year = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        chk = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] val = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(val[j]);
            }
        }

        while (true) {
            melt = new int[n][m];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (map[y][x] != 0) {
                        int z = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx < m && nx >= 0 && ny < n && ny >= 0) {
                                if (map[ny][nx] == 0) z++;
                            }
                        }
                        melt[y][x] = z;
                    }
                }
            }
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    int rs = map[y][x] - melt[y][x];
                    if (rs < 0) rs = 0;
                    map[y][x] = rs;
                }
            }
            chk = new boolean[n][m];
            cnt = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (map[y][x] != 0 && !chk[y][x]) {
                        cnt++;
                        chk[y][x] = true;
                        dfs(y, x);
                    }
                }
            }
            if(cnt == 0){
                year =0;
                break;
            }
            year++;
            if (cnt > 1) break;
        }
        System.out.println(year);
    }

    static void dfs(int y, int x) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < m && nx >= 0 && ny < n && ny >= 0) {
                if (map[ny][nx] != 0 && !chk[ny][nx]) {
                    chk[ny][nx] = true;
                    dfs(ny, nx);
                }
            }
        }
    }
}
