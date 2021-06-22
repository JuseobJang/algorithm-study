package Baekjoon.UnionFind.BOJ4195;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] root;
    static int[] cnt;
    static Map<String, Integer> person;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());
            int personNum = 0;
            String[] input;

            root = new int[2 * n];
            cnt = new int[2 * n];
            person = new HashMap<String, Integer>();

            for (int i = 0; i < 2 * n; i++) {
                root[i] = i;
            }
            Arrays.fill(cnt, 1);

            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                String person1 = input[0];
                String person2 = input[1];
                if (!person.containsKey(person1)) {
                    person.put(person1, personNum++);
                }
                if (!person.containsKey(person2)) {
                    person.put(person2, personNum++);
                }
                ;
                bw.write(merge(person.get(person1), person.get(person2)) + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }


    private static int find(int n) {
        if (root[n] == n) {
            return n;
        } else {
            return root[n] = find(root[n]);
        }
    }

    private static int merge(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 == root2) {
            return cnt[root1];
        } else {
            root[root2] = root1;
            cnt[root1] += cnt[root2];
            return cnt[root1];
        }


    }
}