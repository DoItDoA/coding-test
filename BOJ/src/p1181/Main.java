package p1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, (s1, s2) -> {
            int r = s1.length() - s2.length();
            if (r != 0) return r;
            else return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        for (String l : list) {
            sb.append(l).append("\n");
        }
        System.out.println(sb);
    }
}
