package p1238;
// 보류
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M, X;
    private static int[] dp;
    private static int INF = Integer.MAX_VALUE;
    private static List<Edge>[] graph;
    private static List<Edge>[] graphR;

    private static class Edge {
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        graphR = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            graphR[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graphR[b].add(new Edge(a, c));
        }

        for (int i = 1; i <= N; i++) {
            dp = new int[N + 1];
            Arrays.fill(dp, INF);
            dp[i] = 0;


        }


    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Edge(start, 0));

        while (!q.isEmpty()) {
            Edge p = q.poll();
            if (p.cost > dp[p.node]) continue;

            for (Edge e : graph[p.node]) {
                int cost = p.cost + e.cost;
                if (dp[e.node] > cost) {
                    dp[e.node] = cost;
                    q.add(new Edge(e.node, cost));
                }
            }
        }
    }
}
