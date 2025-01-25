package p1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] chk = new boolean[n + 1];
        List<Edge>[] edgeList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList[a].add(new Edge(b, c));
            edgeList[b].add(new Edge(a, c));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Edge(1, 0));

        int sum = 0;
        int max = 0;
        while (!q.isEmpty()) {
            Edge poll = q.poll();

            if (chk[poll.node]) continue;

            chk[poll.node] = true;
            sum += poll.cost;
            if (max < poll.cost) max = poll.cost;

            for (Edge edge : edgeList[poll.node]) {
                q.add(edge);
            }
        }
        System.out.println(sum - max);
    }
}
