package p2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (String c : cro) {
            if (str.contains(c)) {
                str = str.replace(c, "0");
            }
        }
        System.out.println(str.length());
    }
}
