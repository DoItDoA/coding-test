package p16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int cnt = 1;
        while (true) {
            if (b <= a) break;
            if (b % 10 == 1) {
                String str = b + "";
                b = Integer.parseInt(str.substring(0, str.length() - 1));
            } else if (b % 2 == 0) {
                b /= 2;
            } else {
                break;
            }
            cnt++;
        }
        System.out.println(b == a ? cnt : -1);
    }
}
