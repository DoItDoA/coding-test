package p2887;
// 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<int[]> star = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            star.add(new int[]{x, y, z, i});
        }

        List<int[]> position = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int dim = i;
            Collections.sort(star, (o1, o2) -> Integer.compare(o1[dim], o2[dim]));

            for (int j = 0; j < n - 1; j++) {
                int[] a = star.get(j);
                int[] b = star.get(j + 1);
                int cost = Math.abs(a[dim] - b[dim]);
                position.add(new int[]{a[3], b[3], cost});
            }
        }

        int sum = 0;
        int cnt = 0;

        Collections.sort(position, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int[] p : position) {
            if (union(p[0], p[1])) {
                sum += p[2];
                cnt++;
                if (cnt == n - 1) break;
            }
        }

        System.out.println(sum);
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }
}
