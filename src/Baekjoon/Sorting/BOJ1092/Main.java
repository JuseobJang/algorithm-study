package Baekjoon.Sorting.BOJ1092;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> cranes = new ArrayList<Integer>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(input[i]));
        }

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> boxes = new ArrayList<Integer>();
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(input[i]));
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        int cnt = 0;

        if (cranes.get(0) < boxes.get(0)) {
            bw.write("-1\n");
        } else {
            while (!boxes.isEmpty()) {
                int idx = 0;
                for (int i = 0; i < n; ) {
                    if (boxes.size() == idx) {
                        break;
                    } else if (cranes.get(i) >= boxes.get(idx)) { // 담을 수 있는 경우
                        i++;
                        boxes.remove(idx);
                    } else {
                        idx++;
                    }
                }
                cnt++;
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}