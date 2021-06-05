package Programmers.연습문제.NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Solution sol = new Solution();
        bw.write(Integer.toString(sol.solution(n)));
        bw.flush();

        br.close();
        bw.close();
    }
}

class Solution {
    int queen;
    int cnt;
    int[] col; // col[0] = 1

    public int solution(int n) {
        queen = n;
        col = new int[n];

        backTracking(0);
        return cnt;
    }

    public void backTracking(int n) {
        if (n == queen) {
            cnt++;
            return;
        }
        for (int i = 0; i < queen; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (col[j] - n + j == i || col[j] == i || col[j] + n - j == i) {
                    flag = false;
                }
            }
            if (flag) {
                col[n] = i;
                backTracking(n + 1);
            }
        }
    }
}