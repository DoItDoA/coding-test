package p5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            if (p[1] > dist[p[0]]) continue;

            for (int[] node : graph[p[0]]) {
                int cost = node[1] + p[1];
                if (cost < dist[node[0]]) {
                    dist[node[0]] = cost;
                    pq.add(new int[]{node[0], cost});
                }
            }
        }
        System.out.println(dist[n]);
    }
}
