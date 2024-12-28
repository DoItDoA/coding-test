package Backtracking.p15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int n, m;
    private static List<Integer> list = new ArrayList<>();
    private static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        chk = new boolean[n];

        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(val[i]));
        }
        Collections.sort(list);
        recur(0, new ArrayList<>());
    }

    static void recur(int depth, List<Integer> q) {
        if (depth == m) {
            for (int a : q) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!chk[i]) {
                chk[i] = true;
                q.add(list.get(i));
                recur(depth + 1, q);
                chk[i] = false;
                q.remove(q.size() - 1);
            }
        }
    }
}
