package Baekjoon.Math.BOJ1629;

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
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        long ans = pow(a, b, c);

        bw.write(Long.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    private static long pow(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }
        long num = pow(a, b / 2, c);
        long ret = num * num % c;
        if (b % 2 == 1) { // 홀수
            return ret * a % c;
        } else { // 짝수
            return ret;
        }
    }
}
