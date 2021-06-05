package Baekjoon.BruteForce.BOJ2309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] nan = new int[9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            nan[i] = Integer.parseInt(br.readLine());
            sum += nan[i];
        }
        Arrays.sort(nan);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - nan[i] - nan[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) {
                            continue;
                        } else {
                            System.out.println(nan[k]);
                        }
                    }
                    return;
                }
            }
        }
    }
}
