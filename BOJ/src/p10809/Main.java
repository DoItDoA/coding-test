package p10809;
// 너무 쉬움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] rs = new int[26];
        for (int i = 0; i < 26; i++) {
            rs[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (alphabet[j] == s.charAt(i) && rs[j] == -1) {
                    rs[j] = i;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(rs[i]).append(" ");
        }
        System.out.println(sb);
    }
}
