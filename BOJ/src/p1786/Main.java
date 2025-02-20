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

    private static int[] getSuffixIdx(String pattern) {
        int length = pattern.length();
        int[] si = new int[length]; // 각 위치의 최대 '접미사' 길이를 저장할 배열
        int prefix = 0; // 현재까지 일치하는 '접두사'의 길이

        for (int i = 1; i < length; i++) {
            // prefix = 0이면 아직 일치되는 접두사, 접미사가 없다.
            // prefix > 0 일치되는 접두사가 있다. 현재 문자가 일치하지 않으면 '접두사' 최대 일치 길이 이전으로 돌아감
            while (prefix > 0 && pattern.charAt(prefix) != pattern.charAt(i)) {
                prefix = si[prefix - 1]; // 이전에 계산된 부분 일치 정보를 활용해서 prefix를 줄임
            }

            // 만약 현재 문자와 prefix 위치의 문자가 일치하면, 접두사 일치 길이(prefix)를 증가시키고 pi[i] 접미사 길이 기록
            if (pattern.charAt(prefix) == pattern.charAt(i)) {
                si[i] = ++prefix;
            }
        }
        return si;
    }

    private static void kmp(String text, String pattern) {
        int[] si = getSuffixIdx(pattern);
        int tLen = text.length();
        int pLen = pattern.length();
        int prefix = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tLen; i++) {
            // prefix = 0 이면 일치되는 접두사가 없다.
            // prefix > 0 일치되는 접두사가 있다. 현재 문자가 일치하지 않으면 '접두사' 최대 일치 길이 이전으로 돌아감
            while (prefix > 0 && pattern.charAt(prefix) != text.charAt(i)) {
                prefix = si[prefix - 1]; // 이전에 계산된 부분 일치 정보를 활용해서 prefix를 줄임
            }

            // 각 문자열의 접두사 일치 비교
            if (pattern.charAt(prefix) == text.charAt(i)) {
                // 일치되는 접두사 길이와 패턴문자의 길이가 같을 시
                if (prefix == pLen - 1) {
                    cnt++;
                    sb.append((i + 1) - pLen + 1).append("\n"); // '일치되는 마지막 문자열 - 패턴길이 + 1', i=0부터 시작이니 i+1 해준다.
                    prefix = si[prefix];
                } else {
                    // 접두사가 일치하므로 다음 접두사 위치로 변경
                    prefix++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
