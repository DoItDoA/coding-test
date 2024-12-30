package binary_search.p2805;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long m = Integer.parseInt(input[1]);

        long[] trees = new long[n];
        long maxTree = 0;
        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(val[i]);
            if (trees[i] > maxTree) maxTree = trees[i];
        }

        System.out.println(binarySearch(m, maxTree, trees));

    }

    private static long binarySearch(long target, long maxTree, long[] trees) {
        long left = 0;
        long right = maxTree;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long rs = 0;
            for (long tree : trees) {
                if (tree > mid)
                    rs += (tree - mid);
            }

            if (rs >= target) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
