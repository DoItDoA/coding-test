package p1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[d + 1];
        for (int i = 0; i <= d; i++) {
            graph[i] = new ArrayList<>();
            graph[i].add(new int[]{i + 1, 1});
        }

        int[] dist = new int[d + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a > d || b > d || b - a < c) continue;
            graph[a].add(new int[]{b, c});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[1] > dist[p[0]]) continue;
            if(p[0] >= d) break;

            for (int[] next : graph[p[0]]) {

                int cost = next[1] + p[1];
                if (cost < dist[next[0]]) {
                    dist[next[0]] = cost;
                    q.add(new int[]{next[0], cost});
                }
            }
        }
        System.out.println(dist[d]);
    }
}
