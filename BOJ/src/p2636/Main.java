package p2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int hour = 0;
        int min = Integer.MAX_VALUE;
        while (true) {
            int cnt = countCheese(map);
            if (cnt != 0 && min > cnt) min = cnt;
            if (cnt == 0) break;

            bfs(map);
            removeCheese(map);
            hour++;
        }
        System.out.println(hour);
        System.out.println(min);
    }

    private static int countCheese(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    private static void bfs(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    Queue<int[]> q = new LinkedList<>();
                    boolean[][] chk = new boolean[n][m];
                    q.add(new int[]{i, j});
                    chk[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] poll = q.poll();
                        int y = poll[0];
                        int x = poll[1];
                        if (map[y][x] == 0) {
                            for (int k = 0; k < 4; k++) {
                                int ny = y + dy[k];
                                int nx = x + dx[k];
                                if (ny >= n || ny < 0 || nx >= m || nx < 0) continue;
                                if (!chk[ny][nx]) {
                                    chk[ny][nx] = true;
                                    if (map[ny][nx] == 1) map[ny][nx] = 2;
                                    q.add(new int[]{ny, nx});
                                }
                            }
                        }
                    }
                    return;
                }
            }
        }
    }

    private static void removeCheese(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) map[i][j] = 0;
            }
        }
    }
}
