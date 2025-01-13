package p1436;
// 어려움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = 666;
        while (true) {
            if (String.valueOf(num).contains("666")) {
                cnt++;
            }

            if(cnt == n){
                break;
            }
            num++;
        }
        System.out.println(num);
    }
}
