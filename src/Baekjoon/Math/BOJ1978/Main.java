package Baekjoon.Math.BOJ1978;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int ans = 0;

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < num; i++) {
            int target = arr[i];
            if (isPrime(target)) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
