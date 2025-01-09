package p1157;
// 쉬움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine().toUpperCase();
        int[] cnt = new int[26];

        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i) - 'A']++;
        }
        int max = 0;
        int position = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                position = i;
            }
        }
        int maxCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == max) maxCnt++;
        }

        System.out.println(maxCnt == 1 ? (char) ('A' + position) : "?");
    }
}
