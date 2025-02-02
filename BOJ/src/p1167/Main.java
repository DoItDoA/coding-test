package p1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static List<Edge>[] graph;
    private static int max = 0;
    private static int maxNode = 1;
    private static boolean[] chk;

    private static class Edge {
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        chk = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;
                int c = Integer.parseInt(st.nextToken());

                graph[a].add(new Edge(b, c));
                graph[b].add(new Edge(a, c));
            }
        }

        chk[1] = true;
        dfs(1, 0);

        chk = new boolean[n + 1];
        chk[maxNode] = true;
        dfs(maxNode, 0);
        System.out.println(max);
    }

    private static void dfs(int node, int sum) {
        if (sum > max) {
            max = sum;
            maxNode = node;
        }

        for (Edge edge : graph[node]) {
            if (!chk[edge.node]) {
                chk[edge.node] = true;
                sum += edge.cost;
                dfs(edge.node, sum);
                sum -= edge.cost;
            }
        }
    }
}
