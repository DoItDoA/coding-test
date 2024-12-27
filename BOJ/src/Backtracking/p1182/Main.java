package Backtracking.p1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static int n, s;
    private static int[] list;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        list = new int[n];

        String[] num = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(num[i]);
        }

        recur(0, 0, 0);
        System.out.println(cnt);
    }

    static void recur(int start, int rs, int depth) {
        if (depth == n) {
            return;
        }
        for (int i = start; i < n; i++) {
            int i1 = list[i];
            rs += list[i];
            if (rs == s) cnt++;
            recur(i + 1, rs, depth + 1);
            rs -= list[i];
        }
    }
}
