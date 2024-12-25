package Backtracking.p15650;

import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static boolean[] chk;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        chk = new boolean[n + 1];

        recur(1, 0);
    }

    static void recur(int start, int depth) {
        if (depth == m) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!chk[i]) {
                chk[i] = true;
                list.add(i);
                recur(i, depth + 1);
                chk[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
