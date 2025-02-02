package p1967;
// 어려움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static List<Edge>[] graph;
    private static boolean[] chk;

    private static class Edge {
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private static int max = 0;
    private static int maxNode = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        chk = new boolean[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        chk[1] = true;
        dfs(1, 0);

        chk = new boolean[n + 1];
        chk[maxNode] = true;
        dfs(maxNode, 0);
        System.out.println(max);
    }

    private static void dfs(int start, int sum) {
        if (sum > max) {
            max = sum;
            maxNode = start;
        }

        for (Edge edge : graph[start]) {
            if (!chk[edge.node]) {
                chk[edge.node] = true;
                sum += edge.cost;
                dfs(edge.node, sum);
                sum -= edge.cost;
            }
        }
    }
}
