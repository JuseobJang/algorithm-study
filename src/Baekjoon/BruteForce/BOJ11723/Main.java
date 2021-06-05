package Baekjoon.BruteForce.BOJ11723;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int s = 0;
        for (int i = 0; i < n; i++) {
            String[] ops = br.readLine().split(" ");
            String op = ops[0];
            switch (op) {
                case "all":
                    s |= ~s;
                    break;
                case "empty":
                    s &= 0;
                    break;
                case "add":
                    s |= 1 << Integer.parseInt(ops[1]) - 1;
                    break;
                case "remove":
                    s &= ~(1 << Integer.parseInt(ops[1]) - 1);
                    break;
                case "check":
                    if ((s & 1 << Integer.parseInt(ops[1]) - 1) != 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    s ^= 1 << Integer.parseInt(ops[1]) - 1;
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

}
