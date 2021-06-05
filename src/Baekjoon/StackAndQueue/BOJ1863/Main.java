package Baekjoon.StackAndQueue.BOJ1863;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> down = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] pos = new int[50000];
        for (int i = 0; i < n; i++) {
            pos[i] = Integer.parseInt(br.readLine().split(" ")[1]);
        }
        int count = 0;

        for (int i : pos) {
            while (!down.empty() && down.peek() > i) {
                down.pop();
                count++;
            }
            if (!down.empty() && down.peek() == i) {
                continue;
            }
            down.push(i);
        }
        System.out.println(count);
    }
}
