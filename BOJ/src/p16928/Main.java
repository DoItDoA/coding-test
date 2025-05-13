package p16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.put(start, end);
        }
        boolean[] chk = new boolean[101];


        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        chk[1] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == 100) {
                System.out.println(p[1]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = p[0] + i;
                if (map.containsKey(next)) {
                    next = map.get(next);
                }
                if (next > 100 || chk[next]) continue;
                chk[next] = true;

                q.add(new int[]{next, p[1] + 1});
            }
        }
    }
}
