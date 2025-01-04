package two_pointer.p1806;
// 잘생각해보기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int start = 0, end = 0, sum = 0, len = Integer.MAX_VALUE;
        while (true) {
            if (sum >= s) {
                len = Math.min(len, end - start);
                if (start == n) break;
                sum -= nums[start++];
            } else {
                if (end == n) break;
                sum += nums[end++];
            }
        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
