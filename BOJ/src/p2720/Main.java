package p2720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] money = {25, 10, 5, 1};
        for (int i = 0; i < t; i++) {
            int change = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int m : money) {
                int cnt = change / m;
                sb.append(cnt).append(" ");
                change %= m;
            }
            System.out.println(sb);
        }
    }
}
