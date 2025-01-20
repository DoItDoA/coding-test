package p1005;
// 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            int[] buildTime = new int[n];
            s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                buildTime[i] = Integer.parseInt(s[i]);
            }

            int[] indegree = new int[n];
            int[] dp = new int[n];
            List<List<Integer>> seq = new ArrayList<>();
            while (n-- > 0) {
                seq.add(new ArrayList<>());
            }
            for (int i = 0; i < k; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]) - 1;
                int end = Integer.parseInt(s[1]) - 1;
                seq.get(start).add(end);
                indegree[end]++;
            }
            int w = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                    dp[i] = buildTime[i];
                }
            }

            while (!q.isEmpty()) {
                int poll = q.poll();
                List<Integer> ends = seq.get(poll);
                for (int end : ends) {
                    dp[end] = Math.max(dp[end], dp[poll] + buildTime[end]);
                    indegree[end] -= 1;
                    if (indegree[end] == 0) {
                        q.add(end);
                    }
                }
            }
            System.out.println(dp[w - 1]);
        }
    }
}
