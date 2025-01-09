package p2206;

// 어려움

import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static boolean[][][] check;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    static class Go {
        int[] current;
        int distance;
        boolean isDestroy;

        public Go(int[] c, int d, boolean isD) {
            this.current = c;
            this.distance = d;
            this.isDestroy = isD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        check = new boolean[2][n][m];

        for (int y = 0; y < n; y++) {
            String val = br.readLine();
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(String.valueOf(val.charAt(x)));
            }
        }
        check[0][0][0] = true;
        check[1][0][0] = true;

        int bfs = bfs(new Go(new int[]{0, 0}, 1, false));
        System.out.println(bfs);
    }

    static int bfs(Go go) {
        Queue<Go> q = new LinkedList<>();
        q.add(go);

        while (!q.isEmpty()) {
            Go poll = q.poll();
            int cy = poll.current[0];
            int cx = poll.current[1];

            if (cy == n - 1 && cx == m - 1) return poll.distance;

            for (int k = 0; k < 4; k++) {
                int ny = cy + dy[k];
                int nx = cx + dx[k];

                if (nx >= 0 && ny >= 0 & nx < m && ny < n) {
                    if (map[ny][nx] == 0) {
                        if (!poll.isDestroy && !check[0][ny][nx]) {
                            check[0][ny][nx] = true;
                            q.add(new Go(new int[]{ny, nx}, poll.distance + 1, poll.isDestroy));
                        } else if (poll.isDestroy && !check[1][ny][nx]) {
                            check[1][ny][nx] = true;
                            q.add(new Go(new int[]{ny, nx}, poll.distance + 1, poll.isDestroy));
                        }
                    } else if (map[ny][nx] == 1 && !poll.isDestroy) {
                        check[1][ny][nx] = true;
                        q.add(new Go(new int[]{ny, nx}, poll.distance + 1, true));
                    }
                }
            }
        }
        return -1;
    }
}
