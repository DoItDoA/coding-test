package p2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] chk;

    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    private static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        chk = new boolean[M][N];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !chk[i][j]) {
                    chk[i][j] = true;
                    list.add(bfs(i, j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        StringBuffer sb = new StringBuffer();
        for (int l : list) {
            sb.append(l + " ");
        }
        System.out.println(sb);

    }

    private static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        int size = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            size++;
            for (int k = 0; k < 4; k++) {
                int ny = poll[0] + dy[k];
                int nx = poll[1] + dx[k];

                if (ny >= M || ny < 0 || nx >= N || nx < 0 || chk[ny][nx]) continue;

                if (map[ny][nx] == 0) {
                    chk[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        return size;
    }
}
