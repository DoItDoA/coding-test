package p14501;
// 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int max = 0;
    private static int[] time;
    private static int[] pay;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        time = new int[n];
        pay = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            time[i] = Integer.parseInt(s[0]);
            pay[i] = Integer.parseInt(s[1]);
        }

        recur(0, 0);
        System.out.println(max);
    }

    private static void recur(int start, int sum) {
        if (start > n) {
            return;
        }

        for (int i = start; i < n; i++) {
            int t = time[i];
            int p = pay[i];
            int total = sum + p;
            int day = i + t;

            if (day <= n && max < total) max = total;
            recur(day, total);
        }
    }
}
