import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };

        System.out.println(Arrays.toString(sol.solution(operations)));// 9
        // sol.solution(skoville, k);

    }
}

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();

        int[] answer = new int[2];

        for (String op : operations) {
            String cmd = op.split(" ")[0];
            String val = op.split(" ")[1];

            if (cmd.equals("I")) {
                maxPQ.add(Integer.parseInt(val));
                minPQ.add(Integer.parseInt(val));
            } else {
                if (val.equals("1")) {
                    if (!maxPQ.isEmpty()) {
                        int num = maxPQ.poll();
                        delete(minPQ, num);
                    }
                } else {
                    if (!minPQ.isEmpty()) {
                        int num = minPQ.poll();
                        delete(maxPQ, num);
                    }
                }
            }
        }

        answer[0] = maxPQ.isEmpty() ? 0 : maxPQ.poll();
        answer[1] = minPQ.isEmpty() ? 0 : minPQ.poll();

        return answer;
    }

    public void delete(PriorityQueue<Integer> q, int num) {
        ArrayList<Integer> tmp = new ArrayList<>();
        while (!q.isEmpty()) {
            int a = q.poll();
            if (num == a) {
                break;
            }
            tmp.add(a);
        }
        q.addAll(tmp);
    }
}