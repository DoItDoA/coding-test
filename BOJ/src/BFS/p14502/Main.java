package BFS.p14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
// 어려움

public class Main {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] chk;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        chk = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            String[] val = br.readLine().split(" ");
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(val[x]);
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int cnt) {
        if (cnt == 3) {
            int[][] bfs = bfs();
            checkSafe(bfs);
            return;
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 0) {
                    map[y][x] = 1;
                    dfs(cnt + 1);
                    map[y][x] = 0;
                }
            }
        }
    }

    static int[][] bfs() {
        int[][] temp = new int[n][m];
        for (int y = 0; y < n; y++)
            for (int x = 0; x < m; x++)
                temp[y][x] = map[y][x];

        chk = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (temp[y][x] == 2 && !chk[y][x]) {
                    chk[y][x] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{y, x});
                    while (!q.isEmpty()) {
                        int[] poll = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int ny = poll[0] + dy[k];
                            int nx = poll[1] + dx[k];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                if (temp[ny][nx] == 0 && !chk[ny][nx]) {
                                    temp[ny][nx] = 2;
                                    chk[ny][nx] = true;
                                    q.add(new int[]{ny, nx});
                                }
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }

    static void checkSafe(int[][] temp) {
        int cnt = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (temp[y][x] == 0) cnt++;
            }
        }
        if (cnt > max) max = cnt;
    }
}
