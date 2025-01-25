package p1753;
// 시간 복잡도 (V+E)logV
// 암기

import java.util.*;
import java.io.*;

public class Main {
    public static class Edge {
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private static List<Edge>[] edgeList;
    private static int[] dist;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        edgeList = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            edgeList[i] = new ArrayList<>();
        }
        dist = new int[v + 1];
        Arrays.fill(dist, INF);

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList[a].add(new Edge(b, c));
        }

        dijkstra(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Edge(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Edge poll = q.poll();

            if (poll.cost > dist[poll.node]) continue;

            for (Edge e : edgeList[poll.node]) {
                int cost = e.cost + poll.cost;

                if (cost < dist[e.node]) {
                    dist[e.node] = cost;
                    q.add(new Edge(e.node, cost));
                }
            }
        }
    }
}