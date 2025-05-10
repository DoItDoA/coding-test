package p14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] chk;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chk = new boolean[n][m];
        map = new int[n][m];

        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = 0;
                } else if (map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }

        bfs(start[0], start[1]);
        StringBuilder sb = new StringBuilder();
        for (int[] line : map) {
            for (int num : line) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        chk[x][y] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p[0] + dx[k];
                int ny = p[1] + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || chk[nx][ny] || map[nx][ny] != -1) continue;
                chk[nx][ny] = true;
                map[nx][ny] = p[2] + 1;
                q.add(new int[]{nx, ny, p[2] + 1});
            }
        }
    }
}
