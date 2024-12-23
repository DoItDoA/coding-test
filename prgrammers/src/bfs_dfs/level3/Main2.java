package bfs_dfs.level3;

import java.util.*;

public class Main2 {


    class Solution {
        static class Str {
            int cnt;
            String s;

            public Str(int c, String s) {
                cnt = c;
                this.s = s;
            }
        }


        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            boolean[] chk = new boolean[words.length];

            Queue<Str> q = new LinkedList<>();
            q.add(new Str(0, begin));

            while (!q.isEmpty()) {
                Str poll = q.poll();
                if (poll.s.equals(target)) return poll.cnt;

                for (int k = 0; k < words.length; k++) {
                    String word = words[k];
                    int stringLen = poll.s.length();
                    for (int i = 0; i < poll.s.length(); i++) {
                        String a = String.valueOf(poll.s.charAt(i));
                        String b = String.valueOf(word.charAt(i));
                        if (!a.equals(b)) {
                            stringLen--;
                        }
                    }
                    if (!chk[k] && stringLen == poll.s.length() - 1) {
                        chk[k] = true;
                        q.add(new Str(poll.cnt + 1, word));
                    }
                }
            }
            return answer;
        }

    }
}
