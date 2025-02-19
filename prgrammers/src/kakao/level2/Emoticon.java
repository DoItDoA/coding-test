package kakao.level2;
import java.util.*;
public class Emoticon {

    class Solution {
        private static int[] dis = {40, 30, 20, 10};
        private static int[] emo;
        private static int n;
        private static int[][] user;
        private static int plus = 0;
        private static int sell = 0;
        private static int[] sum;
        public int[] solution(int[][] users, int[] emoticons) {
            emo = emoticons;
            n = emoticons.length;
            user = users;
            sum = new int[user.length];
            recur(0);
            int[] answer = {plus, sell};
            return answer;
        }

        private static void recur(int depth){
            if(depth == n){
                int cnt = 0;
                int total = 0;
                for(int j=0; j<user.length; j++){
                    if(sum[j] >= user[j][1]) cnt++;
                    else total+=sum[j];
                }
                if(cnt>plus) {
                    plus = cnt;
                    sell = total;
                }else if(cnt == plus){
                    if(sell<total) sell= total;
                }
                return;
            }

            for(int i=0; i<4; i++){
                int price = emo[depth] * (100- dis[i]) / 100;
                for(int j=0; j<user.length; j++){
                    if(user[j][0] <= dis[i]) sum[j]+=price;
                }
                recur(depth+1);
                for(int j=0; j<user.length; j++){
                    if(user[j][0] <= dis[i]) sum[j]-=price;
                }
            }
        }
    }

}
