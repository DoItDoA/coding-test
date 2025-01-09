package p2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int max = n / 5;
        int sugar = n;
        for (int k = 0; k <= max; k++) {
            sugar = n;
            cnt = 0;
            for (int i = 0; i < max - k; i++) {
                sugar -= 5;
                cnt++;
            }
            while (true) {
                if (sugar < 3 || sugar == 0) break;
                sugar -= 3;
                cnt++;
            }
            if (sugar == 0) break;
        }
        System.out.println(sugar == 0 ? cnt : -1);
    }
}
