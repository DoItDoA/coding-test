package p7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static boolean[][] chk;
    private static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    private static int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};
    private static int[] start, end;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            chk = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            start = new int[]{x, y, 0};

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            end = new int[]{x, y};

            Queue<int[]> q = new LinkedList<>();
            q.add(start);
            int min = 0;
            while (!q.isEmpty()) {
                int[] poll = q.poll();

                if (end[0] == poll[0] && end[1] == poll[1]) {
                    min = poll[2];
                    break;
                }

                for (int k = 0; k < 8; k++) {
                    int nx = poll[0] + dx[k];
                    int ny = poll[1] + dy[k];

                    if (nx >= I || nx < 0 || ny >= I || ny < 0 || chk[nx][ny]) continue;

                    chk[nx][ny] = true;
                    q.add(new int[]{nx, ny, poll[2] + 1});

                }
            }
            System.out.println(min);
        }
    }
}
