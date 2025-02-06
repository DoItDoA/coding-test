package kakao.level2;
import java.util.*;
public class Donut {

    class Solution {
        private static int[] outdegree;
        private static List<Integer>[] graph;

        public int[] solution(int[][] edges) {
            int len1 = edges.length;
            int n = 0;
            for(int i=0; i< len1; i++){
                for(int j=0; j<2; j++){
                    if(n< edges[i][j]) n = edges[i][j];
                }
            }
            int[] indegree = new int[n+1];
            outdegree= new int[n+1];

            graph = new ArrayList[n+1];
            for(int i=0; i<=n; i++) graph[i] = new ArrayList<>();

            for(int[] edge : edges){
                int a = edge[0];
                int b = edge[1];

                graph[a].add(b);

                outdegree[a]++;
                indegree[b]++;
            }

            int start = 0;
            for(int i=1; i<=n; i++){
                if(indegree[i] ==0 && outdegree[i] >=2){
                    start=i;
                    break;
                }
            }

            int[] answer = new int[4];
            answer[0] = start;
            for(int e: graph[start]){
                int[] rs= bfs(e, n);
                if(rs[0]>rs[1]){
                    answer[2]++;
                }else if(rs[0]<rs[1]){
                    answer[3]++;
                }else{
                    answer[1]++;
                }
            }

            return answer;
        }

        private static int[] bfs(int start, int n){
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            int node = 0;
            int edge = 0;

            boolean[] chk = new boolean[n+1];

            while(!q.isEmpty()){
                int p = q.poll();

                if(!chk[p]){
                    node++;
                }
                chk[p] = true;

                for(int e : graph[p]){
                    if(outdegree[p] > 0){
                        outdegree[p]--;
                        edge++;
                        q.add(e);
                    }
                }
            }
            return new int[]{node, edge};
        }
    }
}
