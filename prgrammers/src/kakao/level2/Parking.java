package kakao.level2;
import java.util.*;

public class Parking {
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            int bTime = fees[0];
            int bPay = fees[1];
            int uTime = fees[2];
            int uPay = fees[3];


            Map<String, List<Car>> map = new TreeMap<>();
            for(String r : records){
                String[] s = r.split(" ");
                String[] time = s[0].split(":");
                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);
                if(!map.containsKey(s[1])) {
                    map.put(s[1], new ArrayList<>());
                }
                List<Car> list = map.get(s[1]);
                list.add(new Car(s[2], hour*60+ minute));
            }
            Set<String> keys = map.keySet();
            int[] answer = new int[keys.size()];
            int idx = 0;
            for(String k : keys){
                List<Car> list = map.get(k);
                if(list.size() % 2 == 1){
                    list.add(new Car("OUT", 23*60 + 59));
                }

                Collections.sort(list, (o1,o2)-> o1.minute - o2.minute);

                int sum = 0;
                for(int i=0; i<list.size(); i+=2){
                    int in = list.get(i).minute;
                    int out = list.get(i+1).minute;

                    sum += out-in;
                }

                int total;
                if(sum > bTime)
                    total = bPay +(int) Math.ceil((sum - bTime) /(double) uTime) * uPay;
                else total = bPay;
                answer[idx++] = total;
            }



            return answer;
        }

        private static class Car{
            String status;
            int minute;
            public Car(String status, int minute){
                this.status = status;
                this.minute = minute;
            }

            public String toString(){
                return minute+" "+status;
            }
        }
    }
}
