package p1010;
// 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            long sum = 1;

            for (int i = 0; i < n; i++) {
                sum *= (m - i);
                sum /= (i + 1);
            }

            System.out.println(sum);
        }
    }
}
