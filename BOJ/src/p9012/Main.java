package p9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String ps = br.readLine();
            int[] cnt = new int[2];
            boolean err = false;
            for (int j = 0; j < ps.length(); j++) {
                char c = ps.charAt(j);
                if (c == '(') cnt[0]++;
                else cnt[1]++;

                if (cnt[0] < cnt[1]) {
                    err = true;
                    break;
                }
            }
            if (err || cnt[0] != cnt[1]) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
