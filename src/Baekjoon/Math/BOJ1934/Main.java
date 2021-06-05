package Baekjoon.Math.BOJ1934;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] lcm = new int[num];

        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            lcm[i] = a * b / gcd(a, b);
        }
        for (int i : lcm) {
            System.out.println(i);
        }
    }
}
