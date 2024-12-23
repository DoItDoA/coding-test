package bfs_dfs.level3;
// 항공경로 어려움
import java.util.*;

public class Main3 {
    class Solution {
        private static boolean[] chk;
        private static int n;
        private static List<String> list = new ArrayList<>();

        public String[] solution(String[][] tickets) {
            n = tickets.length;
            chk = new boolean[n];

            dfs("ICN", "ICN", tickets);
            Collections.sort(list);
            return list.get(0).split(" ");
        }

        public static String dfs(String start, String path, String[][] tickets){
            for(int i=0; i<n; i++){
                if(tickets[i][0].equals(start) && !chk[i]){
                    String end = tickets[i][1];
                    chk[i] = true;
                    String s = dfs(end, path+" "+end, tickets);
                    if(!s.equals("")) list.add(s);
                    chk[i] = false;
                }
            }
            int cnt=0;
            for(boolean b: chk)
                if(b) cnt++;
            return cnt == chk.length ? path: "";

        }
    }
}
