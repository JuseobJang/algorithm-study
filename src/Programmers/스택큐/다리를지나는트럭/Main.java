package Programmers.스택큐.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] truck_weights1 = { 7, 4, 5, 6 };
        int[] truck_weights2 = { 10 };
        int[] truck_weights3 = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

        System.out.println(sol.solution(2, 10, truck_weights1));// 7 17 71 => 3
        System.out.println(sol.solution(100, 100, truck_weights2));// 7 17 71 => 3
        System.out.println(sol.solution(100, 100, truck_weights3));// 7 17 71 => 3
    }

}

class Solution {
    Queue<Integer> bridge = new LinkedList<Integer>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int weights = 0;
        for (int w : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.add(w);
                    time++;
                    weights += w;
                    break;
                }
                if (bridge.size() == bridge_length) {
                    weights -= bridge.poll();
                } else {
                    if (weights + w > weight) {
                        bridge.add(0);
                        time++;
                    } else {
                        bridge.add(w);
                        time++;
                        weights += w;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}