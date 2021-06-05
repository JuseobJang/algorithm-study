package Baekjoon.Simulation.BOJ4396;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static String[][] map;
    static String[][] map_boom;
    static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        map_boom = new String[n][n];

        for (int i = 0; i < n; i++) {
            map_boom[i] = br.readLine().split("");
        }
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        String[][] map_result = new String[n][n];
        boolean boom = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("x")) {
                    int boom_cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int row = i + dirs[k][0];
                        int col = j + dirs[k][1];
                        if(row < 0 || row >= n || col < 0 || col >= n){
                            continue;
                        }
                        if (map_boom[row][col].equals("*")) {
                            boom_cnt++;
                        }
                    }
                    map_result[i][j] = Integer.toString(boom_cnt);
                    if (map_boom[i][j].equals("*")) {
                        boom = true;
                    }
                } else {
                    map_result[i][j] = ".";
                }
            }
        }

        if (boom) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map_boom[i][j].equals("*")) {
                        map_result[i][j] = "*";
                    }
                }
            }
        }

        for (String[] row : map_result) {
            for (String s : row) {
                bw.write(s);
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
