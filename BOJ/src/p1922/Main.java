package p1922;

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
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        List<int[]> infoList = new ArrayList<>();
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            infoList.add(new int[]{a, b, c});
        }
        Collections.sort(infoList, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        int sum = 0;
        int cnt = 0;
        for (int[] info : infoList) {
            if (union(info[0], info[1])) {
                sum += info[2];
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
