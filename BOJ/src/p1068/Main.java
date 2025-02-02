package p1068;

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
        dfs(root);
        System.out.println(root == removeNode ? 0 : cnt);
    }

    private static void dfs(int node) {
        if (graph[node].size() == 0) {
            cnt++;
        }

        for (int a : graph[node]) {
            if (a == removeNode) continue;
            dfs(a);
        }
    }
}
