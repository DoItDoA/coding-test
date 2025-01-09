package p1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static String[][] map;
    private static int n, m;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int max = 0;

    static class Go {
        int cnt;
        String alphabet = "";
        int[] p;

        public Go(int c, String a, int[] p) {
            this.cnt = c;
            alphabet += a;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }

        dfs(new Go(1, map[0][0], new int[]{0, 0}));
        System.out.println(max);
    }

    static void dfs(Go go) {
        int y = go.p[0];
        int x = go.p[1];

        if (go.cnt > max) max = go.cnt;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (!go.alphabet.contains(map[ny][nx])) {
                    String alpha = go.alphabet + map[ny][nx];
                    int cnt = go.cnt + 1;
                    int[] p = new int[]{ny, nx};
                    dfs(new Go(cnt, alpha, p));
                }
            }
        }
    }
}
