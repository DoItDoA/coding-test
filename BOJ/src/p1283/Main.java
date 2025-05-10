package p1283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] words = str.split(" ");

            boolean isAssigned = false;
            for (int j = 0; j < words.length; j++) {
                if (!set.contains(Character.toLowerCase(words[j].charAt(0)))) {
                    set.add(Character.toLowerCase(words[j].charAt(0)));
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    isAssigned = true;
                    break;
                }
            }
            if (!isAssigned) {
                char[] chars = str.toCharArray();
                boolean isParse = false;
                for (int j = 0; j < chars.length; j++) {
                    if (!isParse && chars[j] != ' ' && !set.contains(Character.toLowerCase(chars[j]))) {
                        set.add(Character.toLowerCase(chars[j]));
                        sb.append("[" + chars[j] + "]");
                        isParse = true;
                    } else {
                        sb.append(chars[j]);
                    }
                }
                sb.append("\n");
            } else sb.append(String.join(" ", words)).append("\n");
        }
        System.out.println(sb);
    }
}
