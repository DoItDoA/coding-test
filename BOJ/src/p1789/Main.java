package p1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        long i = 1;
        int n = 0;
        while (true) {
            s -= i++;
            n++;
            if (i > s) break;
        }
        System.out.println(n);
    }
}
