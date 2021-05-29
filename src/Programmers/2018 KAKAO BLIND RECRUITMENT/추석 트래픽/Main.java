public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] a = {
            "2016-09-15 20:59:57.421 0.351s",
            "2016-09-15 20:59:58.233 1.181s",
            "2016-09-15 20:59:58.299 0.8s",
            "2016-09-15 20:59:58.688 1.041s",
            "2016-09-15 20:59:59.591 1.412s",
            "2016-09-15 21:00:00.464 1.466s",
            "2016-09-15 21:00:00.741 1.581s",
            "2016-09-15 21:00:00.748 2.31s",
            "2016-09-15 21:00:00.966 0.381s",
            "2016-09-15 21:00:02.066 2.62s"
        };
        System.out.println(sol.solution(a)); // "()(())()"
        // System.out.println(sol.solution()); // "()(())()"
    }
}

class Solution {
    public int solution(String[] lines) {
        int[] starts = new int[lines.length];
        int[] ends = new int[lines.length];

        getTime(lines, starts, ends);
        int answer = 0;
        for (int i = 0; i < lines.length; i++) {
            int start = starts[i];
            int end = start + 999;
            int cnt = 0;
            for (int j = 0; j < lines.length; j++) {
                if (starts[j] > end || ends[j] < start) {
                    continue;
                } else {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }

        for (int i = 0; i < lines.length; i++) {
            int start = ends[i];
            int end = start + 999;
            int cnt = 0;
            for (int j = 0; j < lines.length; j++) {
                if (starts[j] > end || ends[j] < start) {
                    continue;
                } else {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public void getTime(String[] lines, int[] starts, int[] ends) {
        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");

            String[] times = line[1].split(":");
            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);
            int sec = Integer.parseInt(times[2].substring(0, 2));
            int mSec = Integer.parseInt(times[2].substring(3, 6));

            hour = 60 * 60 * hour * 1000;
            min = 60 * min * 1000;
            sec = sec * 1000;

            int end = hour + min + sec + mSec;

            String[] processTime = line[2].split("s");
            processTime = processTime[0].split("\\.");
            int pt = 0;
            for (int j = 0; j < processTime.length; j++) {
                if (j == 0) {
                    pt += Integer.parseInt(processTime[j]) * 1000;
                } else if (j == 1) {
                    pt += Integer.parseInt(processTime[j]);
                }
            }

            int start = end - pt + 1;

            starts[i] = start;
            ends[i] = end;

        }
    }

}