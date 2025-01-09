package p11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] aList = new int[n];
        int[] bList = new int[m];

        int max = Math.max(n, m);

        input = br.readLine().split(" ");
        for (int i = 0; i < aList.length; i++) {
            aList[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < bList.length; i++) {
            bList[i] = Integer.parseInt(input[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            if (i < aList.length) list.add(aList[i]);
            if (i < bList.length) list.add(bList[i]);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int l : list) sb.append(l).append(" ");
        System.out.println(sb);
        System.out.println();

    }
}
