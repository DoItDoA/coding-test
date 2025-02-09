package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] chk;
    private static int min = Integer.MAX_VALUE;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int n, m;
    private static int[][][] direction = {
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    private static List<int[]> cctv = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) cctv.add(new int[]{i, j, map[i][j]});
            }
        }
        recur(map, 0);
        System.out.println(min);
    }

    private static void recur(int[][] map, int depth) {
        if (depth == cctv.size()) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) cnt++;
                }
            }
            if (cnt < min) min = cnt;
            return;
        }


        int[] c = cctv.get(depth);

        int x = c[0];
        int y = c[1];
        int num = c[2] - 1;

        for (int[] dir : direction[num]) {
            int[][] copy = copy(map);
            see(x, y, dir, copy);


            recur(copy, depth + 1);
        }

    }

    private static void see(int x, int y, int[] dir, int[][] map) {
        for (int d : dir) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            while (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 6) {
                if (map[nx][ny] == 0) {
                    map[nx][ny] = -1;
                }
                nx += dx[d];
                ny += dy[d];
            }
        }
    }

    private static int[][] copy(int[][] map) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
}