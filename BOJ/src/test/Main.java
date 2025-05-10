package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + k - 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k - 1; i++) {
            arr[n + i] = arr[i];
        }
        int[] sushi = new int[d + 1];

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            sushi = new int[d + 1];
            for (int j = i; j < i + k; j++) {
                int num = arr[j];

                if (sushi[num] == 0) {
                    cnt++;
                }
                sushi[num]++;
            }
            if (sushi[c] == 0) cnt++;
            if(max < cnt) max = cnt;
        }
        System.out.println(max);
    }
}