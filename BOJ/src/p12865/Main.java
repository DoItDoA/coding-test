package p12865;
// 존나 어려움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] W = new int[N];
        int[] V = new int[N];

        for (int i = 0; i < N; i++) {
            String[] val = br.readLine().split(" ");
            W[i] = Integer.parseInt(val[0]);
            V[i] = Integer.parseInt(val[1]);
        }

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= W[i]; j--) {
                dp[j] = Math.max(dp[j - W[i]] + V[i], dp[j]);
            }
        }
        System.out.println(dp[K]);
    }
}
