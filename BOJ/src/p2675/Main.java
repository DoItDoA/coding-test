package p2675;
// 너무 쉬움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            String p = input[1];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < p.length(); j++) {
                for (int k = 0; k < r; k++) {
                    sb.append(p.charAt(j));
                }
            }
            System.out.println(sb);
        }
    }
}
