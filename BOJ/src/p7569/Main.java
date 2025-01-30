package p7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int m, n, h;
    private static int[][][] map;
    private static boolean[][][] chk;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dh = {1, -1};

    private static class Tomato {
        int x, y, h, day;

        public Tomato(int h, int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        chk = new boolean[h][n][m];


        Queue<Tomato> q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        q.add(new Tomato(i, j, k, 0));
                        chk[i][j][k] = true;
                    }
                }
            }
        }

        int min = 0;
        while (!q.isEmpty()) {
            Tomato poll = q.poll();
            int hei = poll.h;
            int x = poll.x;
            int y = poll.y;
            min = poll.day;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;

                if (!chk[hei][nx][ny] && map[hei][nx][ny] == 0) {
                    chk[hei][nx][ny] = true;
                    map[hei][nx][ny] = 1;
                    q.add(new Tomato(hei, nx, ny, poll.day + 1));
                }
            }

            for (int k = 0; k < 2; k++) {
                int nh = hei + dh[k];

                if (nh >= h || nh < 0) continue;

                if (!chk[nh][x][y] && map[nh][x][y] == 0) {
                    chk[nh][x][y] = true;
                    map[nh][x][y] = 1;
                    q.add(new Tomato(nh, x, y, poll.day + 1));
                }
            }
        }

        System.out.println(isValid() ? min : -1);
    }

    private static boolean isValid() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }
}
