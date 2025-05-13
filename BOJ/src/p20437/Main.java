package p20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List<Integer>[] positions = new ArrayList[26];
            for (int i = 0; i < 26; i++) positions[i] = new ArrayList<>();

            for (int i = 0; i < W.length(); i++) {
                char ch = W.charAt(i);
                positions[ch - 'a'].add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < 26; i++) {
                List<Integer> pos = positions[i];
                if (pos.size() < K) continue;

                int l = 0;
                int r = K - 1;
                while (r < pos.size()) {
                    int len = pos.get(r) - pos.get(l) + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                    l++;
                    r++;
                }
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
