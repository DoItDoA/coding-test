package BFS.p7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    private static int[][] map;
    private static boolean[][] chk;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int x, y;
    private static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);

        map = new int[y][x];
        chk = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            String[] val = br.readLine().split(" ");
            for (int j = 0; j < x; j++) {
                int tomato = Integer.parseInt(val[j]);
                map[i][j] = tomato;
                if (tomato == 1)
                    q.add(new int[]{i, j});
            }
        }
        bfs();

        int day = 1;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (map[i][j] > day)
                    day = map[i][j];
            }
        }
        System.out.println(day - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int k = 0; k < 4; k++) {
                int ny = poll[0] + dy[k];
                int nx = poll[1] + dx[k];

                if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                    if (map[ny][nx] == 0 && !chk[ny][nx]) {
                        q.add(new int[]{ny, nx});
                        chk[ny][nx] = true;
                        map[ny][nx] = map[poll[0]][poll[1]] + 1;
                    }
                }
            }
        }
    }
}
