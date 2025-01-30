package p2042;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.*;
import java.util.*;

public class Main {
    private static long[] tree;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];

        init(1, n, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, n, b, 1, diff);
            } else {
                sb.append(sum(1, n, 1, b, c)).append("\n");
            }
        }
        System.out.println(sb);
    }


    private static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        long leftSum = init(start, mid, node * 2);
        long rightSum = init(mid + 1, end, node * 2 + 1);
        return tree[node] = leftSum + rightSum;
    }

    private static void update(int start, int end, int idx, int node, long diff) {
        if (idx > end || idx < start) {
            return;
        }

        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(start, mid, idx, node * 2, diff);
            update(mid + 1, end, idx, node * 2 + 1, diff);
        }
    }

    private static long sum(int start, int end, int node, int left, long right) {
        if (end < left || start > right) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        long leftSum = sum(start, mid, node * 2, left, right);
        long rightSum = sum(mid + 1, end, node * 2 + 1, left, right);
        return leftSum + rightSum;
    }

}
