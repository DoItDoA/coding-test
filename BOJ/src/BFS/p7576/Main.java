package BFS.p7576;

import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] chk;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int x, y;
    private static Queue<int[]> q = new LinkedList<>();
    private static Queue<int[]> temp = new LinkedList<>();
    private static int day = 0;

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

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
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
                        temp.add(new int[]{ny, nx});
                        chk[ny][nx] = true;
                        map[ny][nx] = 1;
                    }
                }
            }
        }
        day++;
        while (!temp.isEmpty()) q.add(temp.poll());
        if (!q.isEmpty()) bfs();
    }
}
