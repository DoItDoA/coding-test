package p20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[100001];
        int max = 1;
        int left = 0;
        int right = 0;
        while (right < n) {
            int num = arr[right];
            if (cnt[num] < k) {
                cnt[num]++;
                right++;
                max = Math.max(max, right - left);
            } else {
                cnt[arr[left]]--;
                left++;
            }
        }
        System.out.println(max);
    }
}
