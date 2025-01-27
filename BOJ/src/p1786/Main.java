package p1786;
// kmp O(N + M)
// 암기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        kmp(T, P);
    }

    private static int[] getPi(String pattern) {
        int length = pattern.length();
        int[] pi = new int[length];
        int j = 0;

        for (int i = 1; i < length; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    private static void kmp(String text, String pattern) {
        int[] pi = getPi(pattern);
        int tLen = text.length();
        int pLen = pattern.length();
        int j = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tLen; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pLen - 1) {
                    cnt++;
                    sb.append(i + 1 - pLen + 1).append("\n");
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
