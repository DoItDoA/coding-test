package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            int abs = Math.abs(sum);
            if (min > abs) {
                min = abs;
                l = arr[left];
                r = arr[right];
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                l = arr[left];
                r = arr[right];
                break;
            }
        }
        System.out.println(l + " " + r);
    }
}