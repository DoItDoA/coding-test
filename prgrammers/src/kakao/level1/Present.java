package kakao.level1;

import java.util.*;

public class Present {
    class Solution {
        private static int[][] map;
        private static int[] presentVal;
        private static int max = 0;

        public int solution(String[] friends, String[] gifts) {
            int len = friends.length;
            map = new int[len][len];
            presentVal = new int[len];

            for (String g : gifts) {
                String[] w = g.split(" ");
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        if (friends[i].equals(w[0]) && friends[j].equals(w[1])) {
                            presentVal[i]++;
                            presentVal[j]--;
                            map[i][j]++;
                        }
                    }
                }
            }

            for (int i = 0; i < len; i++) {
                int cnt = 0;
                for (int j = 0; j < len; j++) {
                    if (i == j) continue;
                    if (map[i][j] == map[j][i]) {
                        if (presentVal[i] > presentVal[j]) {
                            cnt++;
                        }
                    } else {
                        if (map[i][j] > map[j][i]) {
                            cnt++;
                        }
                    }
                }
                if (max < cnt) max = cnt;
            }

            return max;
        }
    }

}
