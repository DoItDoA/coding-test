package p1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        boolean[] chk = new boolean[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;
        int p = 1;
        for (int i = 1; i <= N; i++) {
            chk = new boolean[N + 1];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{i, 0});
            chk[i] = true;
            int sum = 0;
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int next = poll[0];
                int cnt = poll[1];

                sum += cnt;

                for (int num : map.get(next)) {
                    if (!chk[num]) {
                        chk[num] = true;
                        q.add(new int[]{num, cnt + 1});
                    }
                }
            }
            if (min > sum) {
                min = sum;
                p = i;
            }
        }
        System.out.println(p);
    }
}
