package p4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Edge {
        double[] node;
        double cost;
        int idx;

        public Edge(double[] node, double cost, int idx) {
            this.node = node;
            this.cost = cost;
            this.idx = idx;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] chk = new boolean[n];
        List<Edge>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        List<double[]> star = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            star.add(new double[]{x, y});
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double[] star1 = star.get(i);
                double[] star2 = star.get(j);
                double cost = Math.sqrt(Math.pow(star1[0] - star2[0], 2) + Math.pow(star1[1] - star2[1], 2));

                list[i].add(new Edge(star2, cost, j));
                list[j].add(new Edge(star1, cost, i));
            }
        }

        PriorityQueue<Edge> q = new PriorityQueue<>(((o1, o2) -> Double.compare(o1.cost, o2.cost)));
        q.add(new Edge(star.get(0), 0, 0));

        double sum = 0;
        while (!q.isEmpty()) {
            Edge poll = q.poll();

            if (chk[poll.idx]) continue;
            chk[poll.idx] = true;
            sum += poll.cost;

            for (Edge edge : list[poll.idx]) {
                q.add(edge);
            }
        }
        System.out.println(Math.round(sum * 100) / 100.0);
    }
}
