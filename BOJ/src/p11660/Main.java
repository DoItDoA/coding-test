package p11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][n];
        int[][] prefixSum = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                sum += prefixSum[j][y2] - prefixSum[j][y1 - 1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
