package p1916;

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

    private static int[] dp;
    private static List<Edge>[] graph;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        graph = new ArrayList[N + 1];

        Arrays.fill(dp, INF);

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dp[end]);
    }

    private static void dijkstra(int start) {
        dp[start] = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Edge(start, 0));

        while (!q.isEmpty()) {
            Edge poll = q.poll();

            if (poll.cost > dp[poll.node]) continue;

            for (Edge edge : graph[poll.node]) {
                int cost = edge.cost + poll.cost;
                if (dp[edge.node] > cost) {
                    dp[edge.node] = cost;
                    q.add(new Edge(edge.node, cost));
                }
            }
        }
    }
}
