package p15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n, m;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        recur(0, "");
        System.out.println(sb);
    }

    static void recur(int depth, String val) {
        if (depth == m) {
            sb.append(val).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            recur(depth + 1, val + i + " ");
        }
    }
}
