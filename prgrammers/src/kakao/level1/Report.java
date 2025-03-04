package kakao.level1;
import java.util.*;

public class Report {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int n = id_list.length;
            Map<String, Integer> map = new HashMap<>();
            for(int i =0; i<n; i++){
                map.put(id_list[i], i);
            }

            boolean[][] status = new boolean[n][n];

            for(String re : report){
                String[] r = re.split(" ");
                String a = r[0];
                String b = r[1];
                int aIdx = map.get(a);
                int bIdx = map.get(b);
                status[bIdx][aIdx] = true;
            }

            int[] answer = new int[n];

            for(int i=0; i<n; i++){
                boolean[] chk = status[i];
                int cnt = 0;
                for(int j=0; j<n; j++){
                    if(chk[j]) cnt++;
                }
                if(cnt >= k){
                    for(int j=0; j<n; j++){
                        if(chk[j]) answer[j]++;
                    }
                }
            }

            return answer;
        }
    }
}
