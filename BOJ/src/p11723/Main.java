package p11723;
// 비트마스킹 암기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int s = 0;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int a = 0;
            if (!command.equals("all") && !command.equals("empty")) {
                a = Integer.parseInt(st.nextToken()) - 1;
            }

            switch (command) {
                case "add":
                    s |= (1 << a);
                    break;
                case "remove":
                    s &= ~(1 << a);
                    break;
                case "check":
                    sb.append((s & 1 << a) == 1 << a ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    s ^= (1 << a);
                    break;
                case "all":
                    s = (1 << 20) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
