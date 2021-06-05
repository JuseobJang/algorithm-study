package Baekjoon.Simulation.BOJ14891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] infos = new int[4][8];
    static int k;
    static int[][] cmd;
    static Gear[] gears = new Gear[4];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;
        for (int i = 0; i < 4; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                infos[i][j] = Integer.parseInt(input[j]);
            }
        }

        k = Integer.parseInt(br.readLine());
        cmd = new int[k][2];

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            cmd[i][0] = Integer.parseInt(input[0]);
            cmd[i][1] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < 4; i++) {
            gears[i] = new Gear(infos[i]);
        }

        for (int i = 0; i < k; i++) {
            checkSide(cmd[i][0] - 1, cmd[i][1]);
            for (int j = 0; j < 4; j++) {
                gears[j].turn();
            }
        }

        int ans = 0;
        ans += gears[0].info[0] * 1;
        ans += gears[1].info[0] * 2;
        ans += gears[2].info[0] * 4;
        ans += gears[3].info[0] * 8;

        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();

    }

    public static void checkSide(int start, int turnDir) {
        int left = start - 1;
        int right = start + 1;

        gears[start].turnDir = turnDir;
        int leftDir = turnDir;
        int rightDir = turnDir;

        while (left >= 0) {
            if (gears[left].info[2] != gears[left + 1].info[6]) {
                leftDir = leftDir * (-1);
                gears[left].turnDir = leftDir;
            } else {
                leftDir = leftDir * (0);
                gears[left].turnDir = leftDir;
            }
            left--;
        }
        while (right < 4) {
            if (gears[right].info[6] != gears[right - 1].info[2]) {
                rightDir = rightDir * (-1);
                gears[right].turnDir = rightDir;
            } else {
                rightDir = rightDir * (0);
                gears[right].turnDir = rightDir;
            }
            right++;
        }
    }

    static class Gear {
        int[] info = new int[8];
        int turnDir; // 0 : no, 1 : 시계, -1 : 반시계

        public Gear(int[] info) {
            this.info = info;
        }

        public void turn() {
            if (turnDir == 0) {
                return;
            } else if (turnDir == 1) {
                int tmp = info[7];
                for (int i = 7; i > 0; i--) {
                    info[i] = info[i - 1];
                }
                info[0] = tmp;
            } else {
                int tmp = info[0];
                for (int i = 0; i < 7; i++) {
                    info[i] = info[i + 1];
                }
                info[7] = tmp;
            }
        }
    }

}
