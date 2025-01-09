package p1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            char temp = ' ';
            boolean[] chk = new boolean[26];
            boolean chk2 = true;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (temp == c || !chk[c - 'a']) {
                    temp = c;
                    chk[c - 'a'] = true;
                    continue;
                }
                chk2 = false;
                break;
            }
            if (chk2) cnt++;
        }
        System.out.println(cnt);
    }
}
