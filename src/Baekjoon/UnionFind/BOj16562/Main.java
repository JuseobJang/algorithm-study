package Baekjoon.UnionFind.BOj16562;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] root;
    static int[] money;
    static int[] group;
    static int n;
    static int m;
    static int r;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        root = new int[n];
        money = new int[n];
        group = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;
            merge(a, b);
        }

        for (int i = 0; i < n; i++) {
            int rootNum = find(i);
            if (group[rootNum] == 0) {
                group[rootNum] = money[i];
            } else {
                group[rootNum] = Math.min(group[rootNum], money[i]);
            }
        }
        int ans = 0;
        for (int mon : group) {
            ans += mon;
        }
        if (ans > r) {
            bw.write("Oh no");

        } else {
            bw.write(Integer.toString(ans));
        }
        bw.flush();

        br.close();
        bw.close();
    }

    private static int find(int n) {
        if (root[n] == n)
            return n; // root[n] == n 이면 트리의 맨위 root 이다.
        else {
            return find(root[n]);
        }
    }

    private static void merge(int a, int b) {
        root[find(b)] = find(a);
    }
}
