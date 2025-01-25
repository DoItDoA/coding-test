package p1197;
// 프림 버전 O((V+E)*logV), 정점의 수가 적을 때 적절

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 암기
public class Main_re {

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

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        boolean[] chk = new boolean[v + 1];
        List<Edge>[] vList = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            vList[i] = new ArrayList<>();
        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            vList[a].add(new Edge(b, c));
            vList[b].add(new Edge(a, c));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Edge(1, 0));

        int total = 0;
        while (!q.isEmpty()) {
            Edge poll = q.poll();

            if (chk[poll.node]) continue;

            chk[poll.node] = true;
            total += poll.cost;

            for (Edge edge : vList[poll.node]) {
                q.add(edge);
            }
        }
        System.out.println(total);
    }
}
