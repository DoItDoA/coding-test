package p11657;
// 벨만 포드 O(V * E)
// 암기
import java.io.*;
import java.util.*;

public class Main {
    private static class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    private static int n, m;
    private static long[] dp;
    private static List<Edge> graph = new ArrayList<>();
    private static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new long[n + 1];
        Arrays.fill(dp, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a, b, c));
        }

        if (bellmanFord()) {
            System.out.println("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                if (dp[i] == INF) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dp[i]).append("\n");
                }
            }
            System.out.println(sb);
        }
    }

    private static boolean bellmanFord() {
        dp[1] = 0;

        for (int i = 1; i <= n; i++) {
            boolean isUpdated = false;
            for (Edge edge : graph) {
                if (dp[edge.start] != INF && dp[edge.end] > dp[edge.start] + edge.cost) {
                    dp[edge.end] = dp[edge.start] + edge.cost;
                    isUpdated = true;
                    if (i == n) {
                        return true;
                    }
                }
            }
            if (!isUpdated) break;
        }
        return false;
    }
}
