package p7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<int[]> testN = new ArrayList<>();
        List<int[]> testM = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] val = br.readLine().split(" ");
            int n = Integer.parseInt(val[0]);
            int m = Integer.parseInt(val[1]);

            int[] a = new int[n];
            val = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(val[j]);
            }

            int[] b = new int[m];
            val = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(val[j]);
            }

            Arrays.sort(a);
            Arrays.sort(b);
            int cnt = 0;

            for (int num : a) {
                cnt += search(b, num);
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static int search(int[] b, int num) {
        int j = 0;
        while (j < b.length) {
            if (b[j] >= num) return j;
            j++;
        }
        return j;
    }
}
