package Baekjoon.UnionFind.BOJ1043;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int truth;
    static int[] root;
    static int[][] member;
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;
        input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        root = new int[n];
        member = new int[m][n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        input = br.readLine().split(" ");
        int truthCnt = Integer.parseInt(input[0]);
        if (truthCnt != 0) {
            truth = Integer.parseInt(input[1]) - 1;
            for (int i = 1; i < truthCnt + 1; i++) {
                merge(truth, Integer.parseInt(input[i]) - 1);
                q.add(Integer.parseInt(input[i]) - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int cnt = Integer.parseInt(input[0]);
            for (int j = 1; j < cnt + 1; j++) {
                member[i][Integer.parseInt(input[j]) - 1] = 1;
            }
        }

        if (truthCnt == 0) {
            bw.write(Integer.toString(m));
            bw.flush();
            br.close();
            bw.close();
            return;
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < m; i++) {
                if (member[i][cur] == 1) {
                    for (int j = 0; j < n; j++) {
                        if (member[i][j] == 1 && find(j) != find(cur)) {
                            merge(cur, j);
                            q.add(j);
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (member[i][j] == 1 && find(truth) == find(j)) {
                    flag = false;
                }
            }
            if (flag) {
                ans++;
            }
        }

        bw.write(Integer.toString(ans));

        bw.flush();
        br.close();
        bw.close();
        return;
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
