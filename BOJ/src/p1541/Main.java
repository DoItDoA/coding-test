package p1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        int result = 0;
        for (int i = 0; i < input.length; i++) {
            String plus = input[i];
            String[] split = plus.split("\\+");
            int sum = 0;
            for (String str : split) {
                sum += Integer.parseInt(str);
            }
            if (i != 0) {
                sum *= -1;
            }
            result += sum;
        }
        System.out.println(result);
    }
}
