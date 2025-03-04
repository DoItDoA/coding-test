package kakao.level5;
import java.util.*;

public class TestDivide {

    class Solution {
        private static List<Integer>[] graph;
        private static int root;
        private static int[] nums;
        private static int cnt = 0;

        public int solution(int k, int[] num, int[][] links) {
            int n = num.length;
            nums = num;
            graph = new ArrayList[n];
            for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

            int[] indegree = new int[n];
            for(int i=0; i<n; i++){
                int[] l = links[i];
                graph[i].add(l[0]);
                if(l[0] != -1)
                    indegree[l[0]]++;

                graph[i].add(l[1]);
                if(l[1] != -1)
                    indegree[l[1]]++;

            }

            for(int i=0; i<n; i++){
                if(indegree[i] == 0) root = i;
            }
            return binarySearch(k);
        }

        private static int binarySearch(int k){
            int left = 0;
            int right = 0;
            int answer = 0;
            for(int num : nums){
                if(num > left) left = num;
                right += num;
            }

            while(left<=right){
                int mid = (left+right)/2;
                if(isChk(mid, k)){
                    answer = mid;
                    right = mid-1;
                }else{
                    left = mid +1;
                }
            }
            return answer;
        }

        private static boolean isChk(int mid, int k){
            cnt = 0;
            if(dfs(root, mid) <= mid){
                cnt++;
            }
            return cnt <= k;
        }

        private static int dfs(int node, int mid){
            if(node == -1) return 0;

            List<Integer> edge = graph[node];
            int left = dfs(edge.get(0), mid);
            int right = dfs(edge.get(1), mid);
            int nodeNum = nums[node];

            if(left+right+nodeNum <= mid){
                return left+right+nodeNum;
            }else if(left+nodeNum <= mid || right+nodeNum <= mid){
                cnt++;
                return Math.min(left, right) + nodeNum;
            }else{
                cnt+=2;
                return nodeNum;
            }
        }
    }
}
