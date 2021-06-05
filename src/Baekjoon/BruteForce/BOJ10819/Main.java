package Baekjoon.BruteForce.BOJ10819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] arr;

    static int makeArr() {
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                int tar = i - 1;
                for (int j = n - 1; j > tar; j--) {
                    if (arr[j] > arr[tar]) {
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
        int max = 0;
        Arrays.sort(arr);
        int start;
        while ((start = makeArr() + 1) != 0) {
            Arrays.sort(arr, start, n);
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
        br.close();
    }
}
