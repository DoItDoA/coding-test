package p17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static boolean[][] chk;
    private static List<int[]> edges = new ArrayList<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        chk = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !chk[i][j]) {
                    numberingIsland(i, j, number++);
                }
            }
        }

        chk = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !chk[i][j]) {
                    bfs(i, j);
                }
            }
        }

        parent = new int[number];
        for (int i = 1; i < number; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        int sum = 0;
        Collections.sort(edges, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                sum += e[2];
                cnt++;
                if (cnt == number - 2) break;
            }
        }
        System.out.println(cnt == number - 2 ? sum : -1);
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false;
        parent[rb] = ra;
        return true;
    }

    private static void numberingIsland(int x, int y, int number) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        chk[x][y] = true;
        map[x][y] = number;
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dx[k];
                int ny = poll[1] + dy[k];
                if (nx >= n || nx < 0 || ny >= m || ny < 0 || chk[nx][ny] || map[nx][ny] == 0) continue;

                chk[nx][ny] = true;
                map[nx][ny] = number;
                q.add(new int[]{nx, ny});
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        chk[x][y] = true;
        int v = map[x][y];
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dx[k];
                int ny = poll[1] + dy[k];
                if (nx >= n || nx < 0 || ny >= m || ny < 0 || chk[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    int[] rs = move(nx, ny, k);
                    if (rs[1] != -1) {
                        edges.add(new int[]{v, rs[0], rs[1]});
                    }
                } else {
                    chk[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static int[] move(int x, int y, int d) {
        int cnt = 1;
        int endPoint = 0;
        while (true) {
            y += dy[d];
            x += dx[d];

            if (x >= n || x < 0 || y >= m || y < 0) {
                cnt = -1;
                break;
            } else if (map[x][y] != 0) {
                endPoint = map[x][y];
                if (cnt == 1) cnt = -1;
                break;
            }
            cnt++;
        }
        return new int[]{endPoint, cnt};
    }
}
