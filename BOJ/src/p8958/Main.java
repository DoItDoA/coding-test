package p8958;
// 쉬움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String val = br.readLine();

            int total = 0;
            int sum = 0;
            for (int j = 0; j < val.length(); j++) {
                if (val.charAt(j) == 'X') {
                    sum = 0;
                } else {
                    sum += 1;
                    total += sum;
                }
            }
            System.out.println(total);
        }
    }
}
