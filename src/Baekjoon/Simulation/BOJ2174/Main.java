package Baekjoon.Simulation.BOJ2174;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int a, b, n, m;
    static Robot[] robots;
    static int[][] map; // 로봇들의 위치 정보

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;
        input = br.readLine().split(" ");
        a = Integer.parseInt(input[1]);
        b = Integer.parseInt(input[0]);

        input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[a][b];
        robots = new Robot[n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int row = Math.abs(Integer.parseInt(input[1]) - a);
            int col = Integer.parseInt(input[0]) - 1;
            int dir;
            if (input[2].equals("N")) {
                dir = 0;
            } else if (input[2].equals("W")) {
                dir = 1;
            } else if (input[2].equals("S")) {
                dir = 2;
            } else {
                dir = 3;
            }
            robots[i] = new Robot(row, col, dir);
            map[row][col] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            String cmd = input[1];
            int iter = Integer.parseInt(input[2]);
            for (int j = 0; j < iter; j++) {
                int[] pos = new int[2];
                int row = robots[num - 1].row;
                int col = robots[num - 1].col;
                pos = robots[num - 1].command(cmd);
                if (pos[0] < 0 || pos[0] >= a || pos[1] < 0 || pos[1] >= b) {
                    System.out.println("Robot " + num + " crashes into the wall");
                    return;
                }
                if (map[pos[0]][pos[1]] != 0 && map[pos[0]][pos[1]] != num) {
                    System.out.println("Robot " + num + " crashes into robot " + map[pos[0]][pos[1]]);
                    return;
                }
                map[row][col] = 0;
                map[pos[0]][pos[1]] = num;
            }
        }
        System.out.println("OK");
        br.close();
        return;
    }
}

class Robot {
    int row;
    int col;
    int dir;
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public Robot(int row, int col, int dir) {
        this.row = row;
        this.col = col;
        this.dir = dir;
    }

    public int[] command(String s) {
        int[] pos = new int[2];
        if (s.equals("L")) {
            pos[0] = row;
            pos[1] = col;
            dir = (dir + 1) % 4;
        } else if (s.equals("R")) {
            pos[0] = row;
            pos[1] = col;
            dir = (dir + 3) % 4;
        } else {
            row += dirs[dir][0];
            col += dirs[dir][1];
            pos[0] = row;
            pos[1] = col;
        }
        return pos;
    }
}