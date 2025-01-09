package p5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());

        int change = 1000 - price;
        int[] money = {500, 100, 50, 10, 5, 1};

        int cnt = 0;
        for (int m : money) {
            cnt += change / m;
            change %= m;
        }
        System.out.println(cnt);
    }
}
