package p2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> ropes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(ropes);

        int max = 0;
        for (int i = 0; i < n; i++) {
            Integer rope = ropes.get(i);
            int w = rope * (n - i);
            if (max < w) max = w;
        }
        System.out.println(max);
    }
}
