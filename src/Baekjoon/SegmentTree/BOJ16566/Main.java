package Baekjoon.SegmentTree.BOJ16566;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, k;
    static int[] a, b;
    static int[] root;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;
        input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        a = new int[m];
        b = new int[k];
        root = new int[n + 1];

        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            b[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n + 1; i++) {
            root[i] = i;
        }

        Arrays.sort(a);
        for (int target : b) {
            int ans = upperBound(a, 0, m, target);
            merge(0, ans);
            bw.write(ans + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    private static int upperBound(int[] arr, int start, int end, int target) {
        int mid;
        while (end - start > 0) {
            mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        while(find(arr[end]) == find(0)) {
            end++;
        }
        return arr[end];
    }

    private static int find(int n) {
        if (root[n] == n)
            return n;
        else {
            return find(root[n]);
        }
    }

    private static void merge(int a, int b) {
        root[find(b)] = find(a);
    }
}
