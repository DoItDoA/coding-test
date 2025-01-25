package p1197;
// 크루스칼 버전 O(E*logE) , 간선의 수가 적을 때 적절
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        List<int[]> edges = new ArrayList<>();
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, c});
        }

        Collections.sort(edges, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        int min = 0;
        int cnt = 0;
        for (int[] edge : edges) {

            if (union(edge[0], edge[1])) {
                min += edge[2];
                cnt++;
                if (cnt == v - 1) break;
            }
        }
        System.out.println(min);
    }

    // 암기
    private static int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    // 암기
    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }
}
