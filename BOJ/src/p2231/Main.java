package p2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 1; i < n; i++) {

            int sum = i;
            String str = sum + "";
            for (int j = 0; j < str.length(); j++) {
                sum += Integer.parseInt(String.valueOf(str.charAt(j)));
            }
            if (sum == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}