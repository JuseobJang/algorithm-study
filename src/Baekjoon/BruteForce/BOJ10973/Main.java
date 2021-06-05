package Baekjoon.BruteForce.BOJ10973;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int n;

    static int makeArr() {
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                int tar = i - 1;
                for (int j = n - 1; j > tar; j--) {
                    if (arr[j] < arr[tar]) {
                        int temp = arr[j];
                        arr[j] = arr[tar];
                        arr[tar] = temp;
                        return tar;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int start = makeArr() + 1;
        if (start == 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(arr, start, n);
            for (int i = start, j = 1; j < (n - start) / 2 + 1; i++, j++) {
                int temp = arr[i];
                arr[i] = arr[n - j];
                arr[n - j] = temp;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
