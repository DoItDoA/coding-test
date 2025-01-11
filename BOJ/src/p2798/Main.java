package p2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] cards = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(cards);

        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum > m) break;
                    if (sum > max) max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
