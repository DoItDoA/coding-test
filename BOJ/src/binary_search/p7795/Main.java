package binary_search.p7795;

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

            Arrays.sort(b);

            int cnt = 0;
            for (int num : a) {
                cnt += lowerBound(b, num);
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    private static int lowerBound(int[] b, int num) {
        int left = 0;
        int right = b.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (b[mid] < num) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return left;
    }
}
