package p5014;
// 쉬움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] d;
    private static int F, S, G, U, D;
    private static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        d = new int[]{U, -D};
        chk = new boolean[F + 1];
        int bfs = bfs();
        System.out.println(bfs == -1 ? "use the stairs" : bfs);
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S, 0});
        chk[S] = true;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (poll[0] == G) return poll[1];

            for (int i = 0; i < 2; i++) {
                int ns = poll[0] + d[i];
                if (ns < 1 || ns > F || chk[ns]) continue;

                chk[ns] = true;
                q.add(new int[]{ns, poll[1] + 1});
            }

        }
        return -1;
    }

}
