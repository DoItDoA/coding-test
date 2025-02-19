package kakao.level3;
import java.util.*;

public class Maze {

    class Solution {
        private static int[][] map;
        private static int[] dx = {1,0,0,-1};
        private static int[] dy = {0,-1,1,0};
        private static List<String> rs = new ArrayList<>();
        private static int n, m, k, x, y, r, c;
        public String solution(int nn, int mm, int xx, int yy, int rr, int cc, int kk) {
            n=nn;
            m=mm;
            k=kk;
            x=xx;
            y=yy;
            r=rr;
            c=cc;
            map = new int[n+1][m+1];

            int dis = Math.abs(x - r)+Math.abs(y-c);
            if((k - dis) % 2 == 1) return "impossible";
            bfs();
            String answer = rs.size() == 0 ?"impossible": rs.get(0);
            return answer;
        }

        private static class Go{
            int x, y, dis;
            String s;
            public Go(int x, int y, int dis, String s){
                this.x=x;
                this.y=y;
                this.dis=dis;
                this.s=s;
            }
            // public String toString(){
            //     return "x: "+x+", y: "+y+", dis: "+dis+", s:"+s;
            // }
        }

        private static void bfs(){
            PriorityQueue<Go> q = new PriorityQueue<>((o1,o2) -> o1.s.compareTo(o2.s));
            q.add(new Go(x, y, 0, ""));
            while(!q.isEmpty()){
                Go g= q.poll();
                if(g.dis == k && g.x == r && g.y == c){
                    rs.add(g.s);
                    break;
                }

                for(int i=0; i<4; i++){
                    int nx = g.x + dx[i];
                    int ny = g.y + dy[i];
                    int nd = g.dis +1;

                    int re = Math.abs(nx - r)+Math.abs(ny-c);

                    if(nx>n || nx<=0 || ny> m || ny<=0 || nd> k || re> k-nd) continue;
                    String s = "";
                    if(i == 0){
                        s=g.s+"d";
                    }else if(i == 1){
                        s=g.s+"l";
                    }else if(i == 2){
                        s=g.s+"r";
                    }else{
                        s=g.s+"u";
                    }
                    q.add(new Go(nx, ny, nd, s));
                }
            }
        }
    }
}
