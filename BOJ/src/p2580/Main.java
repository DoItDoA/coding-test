package p2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[][] map = new int[9][9];
    private static List<int[]> zList = new ArrayList<>();
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 0) zList.add(new int[]{i, j});
            }
        }

        recur();


    }

    static void recur() {
        if (zList.size() == 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0); // 시스템 종료
        }

        for (int[] z : zList) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(i, z)) {
                    map[z[0]][z[1]] = i;
                    zList.remove(0);
                    recur();
                    map[z[0]][z[1]] = 0;
                    zList.add(0, z);
                }
            }
            return;
        }
    }

    static boolean isValid(int num, int[] z) {
        for (int k = 0; k < 4; k++) {
            boolean dfs = dfs(z[0], z[1], k, num);
            if (!dfs) return false;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i / 3 == z[0] / 3 && j / 3 == z[1] / 3) {
                    if (map[i][j] == num) return false;
                }
            }
        }
        return true;
    }


    static boolean dfs(int y, int x, int k, int num) {
        int ny = y + dy[k];
        int nx = x + dx[k];
        if (ny >= 0 && ny < 9 && nx >= 0 && nx < 9) {
            if (num == map[ny][nx]) return false;
            return dfs(ny, nx, k, num);
        }
        return true;
    }
}
