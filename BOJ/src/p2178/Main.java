package p2178;

import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] check;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String val = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(val.charAt(j)));
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int y, int x) {
        int[][] rs = new int[n][m];
        rs[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        while (!q.isEmpty()) {
            int[] idx = q.poll();

            if (idx[0] == n - 1 && idx[1] == m - 1) {
                return rs[n - 1][m - 1];
            }

            for (int i = 0; i < 4; i++) {
                int ay = idx[0] + dy[i];
                int ax = idx[1] + dx[i];
                if (ay >= 0 && ay < n && ax >= 0 && ax < m) {
                    if (map[ay][ax] == 1 && !check[ay][ax]) {
                        check[ay][ax] = true;
                        rs[ay][ax] = rs[idx[0]][idx[1]] + 1;
                        q.add(new int[]{ay, ax});
                    }
                }
            }
        }
        return -1;
    }
}
