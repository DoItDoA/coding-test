package p16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long a;
    private static long b;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        recur(a, 1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void recur(long result, int cnt) {
        if (result > b) return;
        if (result == b) {
            if (min > cnt) min = cnt;
            return;
        }
        result *= 2;
        cnt++;
        recur(result, cnt);
        result /= 2;
        result = Long.parseLong(result + "1");
        recur(result, cnt);
    }
}
