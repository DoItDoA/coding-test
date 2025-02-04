package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        String str = br.readLine();
        int[] dp = new int[n + 2];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[n - 1]);
    }
}