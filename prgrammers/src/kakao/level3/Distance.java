package kakao.level3;
import java.util.*;

public class Distance {

    class Solution {
        private static int n;
        private static char[][] map;
        private static List<int[]> pList;
        private static boolean[][] chk;
        private static int[] dx = {0,1,0,-1};
        private static int[] dy = {1,0,-1,0};

        public int[] solution(String[][] places) {
            n = places.length;
            int[] answer = new int[n];

            for(int i=0; i<n; i++){
                String[] place = places[i];
                map = new char[5][5];
                pList = new ArrayList<>();


                for(int j=0; j<5; j++){
                    String p = place[j];
                    for(int k=0; k<5; k++){
                        map[j][k] = p.charAt(k);
                        if(map[j][k] == 'P') pList.add(new int[]{j,k});
                    }
                }

                boolean isValid = true;
                for(int[] p : pList){
                    chk = new boolean[5][5];
                    if(!bfs(p)){
                        isValid = false;
                        break;
                    }
                }

                answer[i] = isValid ? 1 : 0;
            }


            return answer;
        }

        private static boolean bfs(int[] per){
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{per[0], per[1], 0});
            chk[per[0]][per[1]] = true;

            while(!q.isEmpty()){
                int[] p = q.poll();

                if(p[2] >= 2) continue;

                for(int k =0; k<4; k++){
                    int nx = p[0] + dx[k];
                    int ny = p[1] + dy[k];

                    if(nx >= 5 || nx < 0 || ny >= 5 || ny < 0 || map[nx][ny] == 'X' || chk[nx][ny]) continue;

                    chk[nx][ny] = true;
                    if(map[nx][ny] == 'P') return false;


                    q.add(new int[]{nx, ny, p[2]+1});
                }
            }

            return true;
        }
    }
}
