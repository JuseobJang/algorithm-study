package Baekjoon.BruteForce.BOJ16571;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static ArrayList<String> results;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new int[3][3];
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] != 0) {
                    cnt++;
                }
            }
        }

        int res = 0;
        if (cnt % 2 == 0)
            res = backtrack(1);
        else
            res = backtrack(2);

        if (res == 0)
            bw.write("D");
        else if (res == 1)
            bw.write("W");
        else
            bw.write("L");

        bw.flush();
        br.close();
        bw.close();
    }

    static int backtrack(int turn) {
        if (eval(3 - turn))
            return -1; // (3-turn) : 상대 경우, 상대가 이길경우 난 졌음
        int min = 2;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = turn;
                    min = Math.min(min, backtrack(3 - turn));
                    map[i][j] = 0;
                }
            }
        }
        if (min == 2 || min == 0)
            return 0;
        return -min;
    }

    static boolean eval(int turn) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == turn) {
                if (map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == turn) {
                if (map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                    return true;
                }
            }
        }
        if (map[0][0] == turn) {
            if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
                return true;
            }
        }
        if (map[2][0] == turn) {
            if (map[2][0] == map[1][1] && map[1][1] == map[0][2]) {
                return true;
            }
        }
        return false;
    }
}