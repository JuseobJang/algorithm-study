package Baekjoon.SegmentTree.BOJ5676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {

            int n = Integer.parseInt(input.split(" ")[0]);
            int k = Integer.parseInt(input.split(" ")[1]);

            SegmentTree st = new SegmentTree(n);

            String[] input2 = br.readLine().split(" ");

            for (int i = 1; i <= n; i++) {
                int a = Integer.parseInt(input2[i - 1]);
                if (a == 0) {
                    st.arr[i] = 0;
                } else if (a > 0) {
                    st.arr[i] = 1;
                } else {
                    st.arr[i] = -1;
                }
            }
            st.init(1, 1, n);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < k; i++) {
                String[] input3 = br.readLine().split(" ");
                if (input3[0].equals("C")) {
                    int index = Integer.parseInt(input3[1]);
                    int value = Integer.parseInt(input3[2]);
                    st.change(1, 1, n, index, value);
                } else {
                    int left = Integer.parseInt(input3[1]);
                    int right = Integer.parseInt(input3[2]);
                    if (st.prod(1, 1, n, left, right) > 0) {
                        sb.append("+");
                    } else if (st.prod(1, 1, n, left, right) < 0) {
                        sb.append("-");
                    } else {
                        sb.append(0);
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }

    static class SegmentTree {
        public int[] arr;
        public long[] tr;

        public SegmentTree(int n) {
            this.arr = new int[n + 1];
            int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
            h = (int) Math.pow(2, h);
            this.tr = new long[h];
        }

        void init(int node, int start, int end) {
            if (start == end) {
                tr[node] = arr[start];
            } else {
                init(node * 2, start, (start + end) / 2);
                init(node * 2 + 1, (start + end) / 2 + 1, end);
                tr[node] = tr[node * 2] * tr[node * 2 + 1]; // 구간 곱
            }
        }

        long prod(int node, int start, int end, int left, int right) {
            if (right < start || end < left)
                return 1;
            else if (left <= start && end <= right)
                return tr[node];
            else {
                long l = prod(node * 2, start, (start + end) / 2, left, right);
                long r = prod(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
                return l * r;
            }
        }

        void change(int node, int start, int end, int index, int value) {
            if (index < start || index > end)
                return;
            if (start == end)
                if (value > 0) {
                    tr[node] = 1;
                } else if (value < 0) {
                    tr[node] = -1;
                } else {
                    tr[node] = 0;
                }
            else {
                change(node * 2, start, (start + end) / 2, index, value);
                change(node * 2 + 1, (start + end) / 2 + 1, end, index, value);
                tr[node] = tr[node * 2] * tr[node * 2 + 1];
            }
        }
    }
}
