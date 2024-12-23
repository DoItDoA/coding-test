package bfs_dfs.level3;
// 네트워크
public class Main {
    class Solution {
        private static int[][] map;
        private static boolean[] chk;

        public int solution(int n, int[][] computers) {
            map = computers;
            chk = new boolean[n];
            int answer =0;
            for(int k=0; k<n; k++){
                for(int i=0; i<n; i++){
                    if(!chk[i] && map[k][i]==1){
                        answer++;
                        chk[i]=true;
                        dfs(i, n);
                    }
                }
            }
            return answer;
        }

        static void dfs(int i, int n){
            for(int j=0; j<n; j++){
                if(!chk[j] && map[i][j]==1){
                    chk[j]=true;
                    dfs(j, n);
                }
            }
        }
    }
}
