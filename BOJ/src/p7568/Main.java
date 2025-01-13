package p7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int[] man = {Integer.parseInt(s[0]), Integer.parseInt(s[1]), 1};
            list.add(man);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] p1 = list.get(i);
                int[] p2 = list.get(j);
                if (i != j && p1[0] < p2[0] && p1[1] < p2[1]) {
                    p1[2] += 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i)[2]).append(" ");
        }
        System.out.println(sb);
    }
}
