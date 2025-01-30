package p2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static List<Integer>[] graph;
    private static boolean chk[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        chk = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start, 0});
        chk[start] = true;

        int cnt = -1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (poll[0] == end) {
                cnt = poll[1];
                break;
            }

            for (int e : graph[poll[0]]) {
                if (!chk[e]) {
                    chk[e] = true;
                    q.add(new int[]{e, poll[1] + 1});
                }
            }
        }
        System.out.println(cnt);
    }
}
