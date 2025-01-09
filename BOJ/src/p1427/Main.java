package p1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n.length(); i++) {
            list.add(n.charAt(i));
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (char l : list) {
            sb.append(l);
        }
        System.out.println(sb);
    }
}
