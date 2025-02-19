package kakao.level1;
import java.util.*;
public class Information {
    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            String[] todays = today.split("\\.");
            int year = Integer.parseInt(todays[0]);
            int month = Integer.parseInt(todays[1]);
            int day = Integer.parseInt(todays[2]);

            Map<String,Integer> map = new HashMap<>();
            for(String term: terms){
                String[] t = term.split(" ");
                map.put(t[0], Integer.parseInt(t[1]));
            }


            List<Integer> list = new ArrayList<>();
            for(int i=0; i<privacies.length; i++){
                String pri =privacies[i];

                String[] p = pri.split(" ");
                String date = p[0];
                int term = map.get(p[1]);

                String[] dates = date.split("\\.");
                int dYear = Integer.parseInt(dates[0]);
                int dMonth = Integer.parseInt(dates[1]);
                int dDay = Integer.parseInt(dates[2]);

                if(term>=12) {
                    dYear += term/12;
                    term = term%12;
                }

                dMonth += term;
                if(dMonth >12){
                    dYear++;
                    dMonth %= 12;
                }


                if(dYear < year){
                    list.add(i+1);
                }else if(dYear == year){
                    if(dMonth<month){
                        list.add(i+1);
                    }else if(dMonth==month){
                        if(dDay <= day){
                            list.add(i+1);
                        }
                    }
                }
            }


            int[] answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }


            return answer;
        }
    }
}
