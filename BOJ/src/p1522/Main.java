package p1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        String ss = s + s;

        int countA = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') countA++;
        }

        if (countA == 0 || countA == len) {
            System.out.println(0);
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int j = i; j < i + countA; j++) {
                if (ss.charAt(j) == 'b') cnt++;
            }
            if (min > cnt) min = cnt;
        }
        System.out.println(min);
    }
}
