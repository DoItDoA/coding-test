package backtracking.p15683;
// 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int n, m;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    static int[][][] directions = {
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };
    private static List<int[]> cctvList = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int[][] map = new int[n][m];

        for (int y = 0; y < n; y++) {
            String[] val = br.readLine().split(" ");
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(val[x]);
                if (map[y][x] != 6 && map[y][x] != 0) cctvList.add(new int[]{y, x});
            }
        }

        recur(0, map);
        System.out.println(min);
    }

    static void recur(int depth, int[][] map) {
        if (depth == cctvList.size()) {
            int cnt = checkZero(map);
            if (min > cnt) min = cnt;
            return;
        }

        int[] cctv = cctvList.get(depth);
        int y = cctv[0];
        int x = cctv[1];

        for (int[] dir : directions[map[y][x] - 1]) {
            int[][] copy = copyMap(map);
            int[][] changeMap = monitor(y, x, dir, copy);
            recur(depth + 1, changeMap);
        }
    }

    static int[][] monitor(int y, int x, int[] dir, int[][] map) {
        for (int d : dir) {
            int ny = y;
            int nx = x;
            while (true) {
                ny += dy[d];
                nx += dx[d];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (map[ny][nx] == 6) break;
                    if (map[ny][nx] == 0) map[ny][nx] = -1;
                }
                if (ny < 0 || ny == n || nx < 0 || nx == m) break;
            }
        }
        return map;
    }

    static int[][] copyMap(int[][] map) {
        int[][] copy = new int[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                copy[y][x] = map[y][x];
            }
        }
        return copy;
    }

    static int checkZero(int[][] map) {
        int cnt = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 0) cnt++;
            }
        }
        return cnt;
    }
}