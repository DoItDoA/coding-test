package p1504;
// 주의

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Edge {
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private static int INF = Integer.MAX_VALUE;
    private static List<Edge>[] graph;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dp1 = dijkstra(1);
        int[] dpV1 = dijkstra(v1);
        int[] dpV2 = dijkstra(v2);

        long cost1 = (long) dp1[v1] + (long) dpV1[v2] + (long) dpV2[N];
        long cost2 = (long) dp1[v2] + (long) dpV2[v1] + (long) dpV1[N];

        long min = Math.min(cost1, cost2);

        System.out.println(min >= INF ? -1 : min);

    }

    private static int[] dijkstra(int start) {
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Edge(start, 0));
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);
        dp[start] = 0;

        while (!q.isEmpty()) {
            Edge p = q.poll();

            if (p.cost > dp[p.node]) continue;

            for (Edge e : graph[p.node]) {
                int cost = e.cost + p.cost;

                if (dp[e.node] > cost) {
                    dp[e.node] = cost;
                    q.add(new Edge(e.node, cost));
                }
            }
        }
        return dp;
    }
}
