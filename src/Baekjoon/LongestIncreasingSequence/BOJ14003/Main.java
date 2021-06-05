package Baekjoon.LongestIncreasingSequence.BOJ14003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] arr;
    static int[] p;
    static ArrayList<Integer> lis;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        p = new int[n];
        lis = new ArrayList<Integer>();

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        lis.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
                p[i] = lis.size() - 1;
            } else {
                int l = lowerBound(arr[i]);
                lis.set(l, arr[i]);
                p[i] = l;
            }
        }
        bw.write(Integer.toString(lis.size()) + "\n");

        StringBuilder sb = new StringBuilder();
        int last = lis.size() - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (last == p[i]) {
                sb.insert(0, Integer.toString(arr[i]) + " ");
                last--;
            }
        }
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    public static int lowerBound(int target) {
        int start = 0;
        int end = lis.size();
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (lis.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}