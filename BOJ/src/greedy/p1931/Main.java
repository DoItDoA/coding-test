package greedy.p1931;
// 정렬이 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Meeting> meetingList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] val = br.readLine().split(" ");
            int start = Integer.parseInt(val[0]);
            int end = Integer.parseInt(val[1]);
            meetingList.add(new Meeting(start, end));
        }

        Collections.sort(meetingList, (m1, m2) -> {
            if (m1.end == m2.end) return Integer.compare(m1.start, m2.start);
            return Integer.compare(m1.end, m2.end);
        });

        int cnt = 0;
        int endTime = 0;
        for (Meeting m : meetingList) {
            if (m.start >= endTime) {
                cnt++;
                endTime = m.end;
            }
        }
        System.out.println(cnt);
    }

    private static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
