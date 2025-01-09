package p10162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sec = {300, 60, 10};

        StringBuilder sb = new StringBuilder();
        for (int s : sec) {
            sb.append(n / s).append(" ");
            n %= s;
        }
        System.out.println(n == 0 ? sb : -1);
    }
}
