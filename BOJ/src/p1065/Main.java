package p1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 99;
        if (n >= 100) {
            for (int j = 100; j <= n; j++) {
                String str = j + "";
                Integer temp = null;
                boolean chk = false;
                for (int i = 0; i < str.length() - 1; i++) {
                    int n1 = Integer.parseInt(String.valueOf(str.charAt(i)));
                    int n2 = Integer.parseInt(String.valueOf(str.charAt(i + 1)));
                    if (temp == null) temp = n1 - n2;
                    else if (temp != (n1 - n2)) chk = true;
                }
                if (!chk) cnt++;
            }
        }

        System.out.println(n < 100 ? n : cnt);
    }
}
