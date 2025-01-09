package p2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] nums = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n - i; j++) {
                sum += nums[i + j];
                if (sum == m) {
                    count++;
                    break;
                } else if (sum > m) break;
            }
        }
        System.out.println(count);
    }
}
