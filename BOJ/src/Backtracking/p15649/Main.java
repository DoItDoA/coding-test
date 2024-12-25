package Backtracking.p15649;

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static List<Integer> rs = new ArrayList<>();
    private static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        chk = new boolean[n];

        recur(0);
    }

    static void recur(int num) {
        if (num == m) {
            for (int i : rs)
                System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                rs.add(i + 1);
                chk[i] = true;
                recur(num + 1);
                chk[i] = false;
                rs.remove(rs.size() - 1);
            }
        }
    }
}
