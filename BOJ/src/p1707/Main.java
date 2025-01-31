package p1707;
// 주의
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node {
        int node;
        int binary;

        public Node(int node, int binary) {
            this.node = node;
            this.binary = binary;
        }
    }

    private static List<List<Integer>> graph;
    private static int[] binary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }
            binary = new int[V + 1];

            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            boolean chk = true;
            for (int i = 1; i <= V; i++) {
                if (!bfs(i)) chk = false;
            }

            System.out.println(chk ? "YES" : "NO");

        }
    }

    private static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        if (binary[start] == 0) binary[start] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();

            for (Integer i : graph.get(node)) {
                if (binary[i] == 0) {
                    binary[i] = -binary[node];
                    q.add(i);
                } else if (binary[i] == binary[node]) return false;
            }
        }
        return true;
    }
}
