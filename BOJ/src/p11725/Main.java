package p11725;

import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> map;
    private static boolean[] chk;
    private static int n;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        chk = new boolean[n];
        parent = new int[n - 1];

        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int n1 = Integer.parseInt(s[0]) - 1;
            int n2 = Integer.parseInt(s[1]) - 1;
            map.get(n1).add(n2);
            map.get(n2).add(n1);
        }
        chk[0] = true;
        dfs(0);
        for (int p : parent) {
            System.out.println(p);
        }
    }

    static void dfs(int num) {
        List<Integer> nodes = map.get(num);
        for (int node : nodes) {
            if (!chk[node]) {
                chk[node] = true;
                parent[node - 1] = num + 1;
                dfs(node);
            }
        }
    }
}
