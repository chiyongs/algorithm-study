package programmers.카카오.블라인드채용2018.추석트래픽;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Solution {

    static class Request implements Comparable<Request> {
        LocalDateTime start;
        LocalDateTime end;

        public Request(String line) {
            StringTokenizer st = new StringTokenizer(line, " ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String time = st.nextToken() + " " + st.nextToken();
            this.end = LocalDateTime.parse(time, formatter);

            String executionTime = st.nextToken();
            executionTime = executionTime.substring(0, executionTime.length()-1);

            long nanos = 0L;
            if(executionTime.contains(".")) {
                st = new StringTokenizer(executionTime, ".");
                String first = st.nextToken();
                String second = st.nextToken();

                while(second.length() < 7) {
                    second += "0";
                }

                this.start = end.minusSeconds(Long.parseLong(first));
                this.start = start.minusNanos(Long.parseLong(second));
                this.start = start.plusNanos(1000000);
            } else {
                nanos = Long.parseLong(executionTime);
                this.start = end.minusSeconds(nanos);
                this.start = start.plusNanos(1000000);
            }
        }

        @Override
        public String toString() {
            return "Request{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public int compareTo(Request o) {
            if (this.end.isEqual(o.end)) {
                if(this.start.isBefore(o.start)) return -1;
                else if(this.start.isAfter(o.start)) return 1;
                else return 0;
            }
            if(this.end.isBefore(o.end)) return -1;
            else if(this.end.isAfter(o.end)) return 1;
            else return 0;
        }
    }

    public int solution(String[] lines) {
        List<Request> requests = new ArrayList<>();
        for(String line: lines) {
            requests.add(new Request(line));
        }

        Collections.sort(requests);

        System.out.println(Arrays.toString(requests.toArray()));

        int answer = 1;
        int cnt = 1;
        LocalDateTime cur = requests.get(0).end;
        for(int i=1;i<requests.size();i++) {
            LocalDateTime comp = requests.get(i).start.plusSeconds(1);
            if(comp.isBefore(cur)) cnt++;
            else if(comp.minusSeconds(1).isBefore(cur)) cnt++;
            else {
                cnt = 1;
                cur = requests.get(i).end;
            }
            if(cnt > answer) answer = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        S.solution(lines);
    }

//    static String[] lines = {"2016-09-15 01:00:04.002 2.0s",
//            "2016-09-15 01:00:07.000 2s"};
//    static String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};

    static String[] lines = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
}
