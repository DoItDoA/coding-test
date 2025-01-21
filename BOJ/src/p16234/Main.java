package p16234;
// 살짝 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int n, l, r;
    private static int[][] map, chk;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int day = 0;
        while (true) {
            boolean isContinue = false;
            chk = new int[n][n];
            int countryNum = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (chk[i][j] == 0) {
                        chk[i][j] = countryNum;
                        int[] bfs = bfs(i, j, map[i][j], countryNum++);
                        if (bfs[0] != 1) {
                            isContinue = true;
                            int people = bfs[1] / bfs[0];

                            for (int y = 0; y < n; y++) {
                                for (int x = 0; x < n; x++) {
                                    if (chk[y][x] == bfs[2]) map[y][x] = people;
                                }
                            }
                        }
                    }
                }
            }
            if(!isContinue) break;
            day++;
        }
        System.out.println(day);
    }

    private static int[] bfs(int y, int x, int sum, int countryNum) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        int size = 1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int k = 0; k < 4; k++) {
                int ny = poll[0] + dy[k];
                int nx = poll[1] + dx[k];
                if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;

                int current = map[poll[0]][poll[1]];
                int side = map[ny][nx];
                int abs = Math.abs(current - side);
                if (chk[ny][nx] == 0 && l <= abs && abs <= r) {
                    chk[ny][nx] = countryNum;
                    q.add(new int[]{ny, nx});
                    size++;
                    sum += map[ny][nx];
                }
            }
        }
        return new int[]{size, sum, countryNum};
    }
}
