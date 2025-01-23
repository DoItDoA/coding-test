package p2638;

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
        int time = 0;
        while (true) {
            int cnt = checkCheese(map);
            if (cnt == 0) break;
            bfs(map);
            removeCheese(map);
            time++;
        }
        System.out.println(time);
    }

    private static int checkCheese(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    private static void removeCheese(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 2) map[i][j] = 0;
                else if (map[i][j] == 2) map[i][j] = 1;
            }
        }
    }

    private static void bfs(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    boolean[][] chk = new boolean[n][m];
                    Queue<int[]> q = new LinkedList<>();
                    chk[i][j] = true;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] poll = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int ny = poll[0] + dy[k];
                            int nx = poll[1] + dx[k];

                            if (ny >= n || ny < 0 || nx >= m || nx < 0 || chk[ny][nx]) continue;

                            if (map[ny][nx] == 0) {
                                chk[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            } else {
                                map[ny][nx]++;
                            }
                        }
                    }
                    return;
                }
            }
        }
    }
}
