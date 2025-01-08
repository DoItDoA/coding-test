package two_pointer.p2531;
// 존나 어려움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] sushi = new int[n + k];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            sushi[n + i] = sushi[i];
        }

        int[] count = new int[d + 1];
        int unique = 0;
        for (int i = 0; i < k; i++) {
            int num = sushi[i];
            if (count[num] == 0) unique++;
            count[num]++;
        }
        int max = unique;

        for (int i = 0; i < n; i++) {
            int num = sushi[i];
            count[num]--;
            if (count[num] == 0) unique--;

            num = sushi[i + k];
            if (count[num] == 0) unique++;
            count[num]++;

            int total = unique + (count[c] == 0 ? 1 : 0);
            if (max < total) max = total;
        }
        System.out.println(max);
    }
}
