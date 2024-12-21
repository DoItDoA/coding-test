package DFS.p10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String[][] map;
    private static boolean[][] chk;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        chk = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }

        int cnt1 = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!chk[y][x]) {
                    cnt1++;
                    chk[y][x] = true;
                    dfs1(y, x, map[y][x]);
                }
            }
        }

        int cnt2 = 0;
        chk = new boolean[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x].equals("R")) map[y][x] = "G";
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!chk[y][x]) {
                    cnt2++;
                    chk[y][x] = true;
                    dfs1(y, x, map[y][x]);
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }

    static void dfs1(int y, int x, String s) {
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                if (map[ny][nx].equals(s) && !chk[ny][nx]) {
                    chk[ny][nx] = true;
                    dfs1(ny, nx, s);
                }
            }
        }
    }
}
