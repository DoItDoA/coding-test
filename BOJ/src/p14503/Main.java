package p14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int y = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int cnt = 1;
        map[y][x] = 2;
        while (true) {
            boolean allClean = true;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (map[ny][nx] == 0) {
                    map[ny][nx] = 2;
                    cnt++;
                    y = ny;
                    x = nx;
                    allClean = false;
                    break;
                }
            }
            if (allClean) {
                int back = (d + 2) % 4;
                int by = y + dy[back];
                int bx = x + dx[back];
                if (map[by][bx] == 1) break;
                y = by;
                x = bx;
            }
        }
        System.out.println(cnt);
    }
}
