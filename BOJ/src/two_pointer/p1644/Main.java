package two_pointer.p1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> primeList = new ArrayList<>();
        boolean[] chk = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!chk[i]) {
                primeList.add(i);
                for (int j = i; j <= n; j += i) {
                    chk[j] = true;
                }
            }
        }

        int start = 0, end = 0, sum = 0, cnt = 0;
        while (true) {
            if (sum >= n) {
                sum -= primeList.get(start++);
            } else if (end == primeList.size()) {
                break;
            } else {
                sum += primeList.get(end++);
            }

            if (sum == n) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
