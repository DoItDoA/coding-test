package p14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] dice = new int[6];

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        int y = Integer.parseInt(s[3]);
        int k = Integer.parseInt(s[4]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(s[i]);
            y = y + dy[command - 1];
            x = x + dx[command - 1];

            if (x >= n || x < 0 || y >= m || y < 0) {
                y = y - dy[command - 1];
                x = x - dx[command - 1];
                continue;
            }

            if (command == 1) {
                int temp = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
            } else if (command == 2) {
                int temp = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[0];
                dice[0] = temp;
            } else if (command == 3) {
                int temp = dice[3];
                dice[3] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
            } else {
                int temp = dice[3];
                dice[3] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
            }
            if (map[x][y] == 0) {
                map[x][y] = dice[5];
            } else {
                dice[5] = map[x][y];
                map[x][y] = 0;
            }
            sb.append(dice[3]).append("\n");
        }
        System.out.println(sb);
    }
}
