package BFS.p1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] map;
    private static boolean[][] check;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        check = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            String[] binary = br.readLine().split(" ");
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(binary[x]);
            }
        }

        int count = 0;
        int max = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                int binary = map[y][x];
                boolean chk = check[y][x];
                if (binary == 1 && !chk) {
                    check[y][x] = true;
                    count++;
                    max = Math.max(max, bfs(y, x));
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    static int bfs(int y, int x) {
        int rs = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while (q.size() != 0) {
            int[] currentYX = q.poll();
            for (int i = 0; i < 4; i++) {
                int ay = currentYX[0] + dy[i];
                int ax = currentYX[1] + dx[i];

                if (ax >= 0 && ax < m && ay >= 0 && ay < n) {
                    if (map[ay][ax] == 1 && !check[ay][ax]) {
                        check[ay][ax] = true;
                        rs++;
                        q.add(new int[]{ay, ax});
                    }
                }
            }
        }

        return rs;
    }
}
