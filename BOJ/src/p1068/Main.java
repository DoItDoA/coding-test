package p1068;
// 조금 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n, removeNode;
    private static List<Integer>[] graph;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != -1) {
                graph[num].add(i);
            } else root = i;
        }
        removeNode = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 0) continue;
            if (i == removeNode) graph[i] = new ArrayList<>();

            int idx = graph[i].indexOf(removeNode);
            if (idx != -1) graph[i].remove(idx);
        }

        dfs(root);
        System.out.println(removeNode == root ? 0 : cnt);
    }

    private static void dfs(int node) {
        if (graph[node].size() == 0) {
            cnt++;
        }

        for (int a : graph[node]) {
            dfs(a);
        }
    }
}
