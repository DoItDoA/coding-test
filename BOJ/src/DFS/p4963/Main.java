package DFS.p4963;

import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static List<int[][]> mapList = new ArrayList<>();
    public static List<boolean[][]> chkList = new ArrayList<>();
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            if (m == 0 && n == 0) break;

            int[][] map = new int[n][m];
            boolean[][] chk = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                String[] val = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(val[j]);
                }
            }
            mapList.add(map);
            chkList.add(chk);
        }
        int size = mapList.size();
        for (int k = 0; k < size; k++) {
            int[][] map = mapList.get(k);
            boolean[][] chk = chkList.get(k);
            int n = map.length;
            int m = map[n - 1].length;
            int cnt = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (!chk[y][x] && map[y][x] == 1) {
                        cnt++;
                        chk[y][x] = true;
                        dfs(y, x, n, m, map, chk);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int y, int x, int n, int m, int[][] map, boolean[][] chk) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (map[ny][nx] == 1 && !chk[ny][nx]) {
                    chk[ny][nx] = true;
                    dfs(ny, nx, n, m, map, chk);
                }
                for (int h = 0; h < 2; h++) {
                    int ax = nx + dx[k % 2 == 0 ? h * 2 + 1 : h * 2];
                    int ay = ny + dy[k % 2 == 0 ? h * 2 + 1 : h * 2];
                    if (ax >= 0 && ax < m && ay >= 0 && ay < n) {
                        if (map[ay][ax] == 1 && !chk[ay][ax]) {
                            chk[ay][ax] = true;
                            dfs(ay, ax, n, m, map, chk);
                        }
                    }
                }
            }
        }
    }
}
