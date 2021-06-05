package Baekjoon.BruteForce.BOJ9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] l = new int[10];

    static void make() {
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                l[i] = 1;
            } else if (i == 1) {
                l[i] = 2;
            } else if (i == 2) {
                l[i] = 4;
            } else {
                for (int j = i; j > i - 3; j--) {
                    l[i] += l[j - 1];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        make();
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            System.out.println(l[num[i] - 1]);
        }
    }
}
