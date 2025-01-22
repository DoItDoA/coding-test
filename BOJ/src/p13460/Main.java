package p13460;
// 존나 어려움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int n, m;
    private static char[][] map;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static boolean[][][][] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new char[n][m];
        chk = new boolean[n][m][n][m];
        int ry = 0, rx = 0, by = 0, bx = 0;

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j];
                if (map[i][j] == 'R') {
                    ry = i;
                    rx = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    by = i;
                    bx = j;
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(ry, rx, by, bx));
    }

    private static int bfs(int ry, int rx, int by, int bx) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ry, rx, by, bx, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cry = poll[0];
            int crx = poll[1];
            int cby = poll[2];
            int cbx = poll[3];
            int cmove = poll[4];
            chk[cry][crx][cby][cbx] = true;

            if (cmove >= 10) return -1;

            for (int k = 0; k < 4; k++) {
                int[] rMove = move(cry, crx, k);
                int nry = rMove[0];
                int nrx = rMove[1];
                int rcnt = rMove[2];
                int[] bMove = move(cby, cbx, k);
                int nby = bMove[0];
                int nbx = bMove[1];
                int bcnt = bMove[2];

                if (nby == -1 && nbx == -1) {
                    continue;
                }
                if (nry == -1 && nrx == -1) {
                    return cmove + 1;
                }

                if (nry == nby && nrx == nbx) {
                    if (rcnt > bcnt) {
                        nry -= dy[k];
                        nrx -= dx[k];
                    } else {
                        nby -= dy[k];
                        nbx -= dx[k];
                    }
                }
                if (!chk[nry][nrx][nby][nbx]) {
                    chk[nry][nrx][nby][nbx] = true;
                    q.add(new int[]{nry, nrx, nby, nbx, cmove + 1});
                }
            }
        }
        return -1;
    }

    private static int[] move(int y, int x, int k) {
        int cnt = 0;
        while (map[y][x] != '#') {
            y = y + dy[k];
            x = x + dx[k];
            if (map[y][x] == 'O') return new int[]{-1, -1, 0};
            cnt++;
        }
        return new int[]{y - dy[k], x - dx[k], cnt};
    }
}
