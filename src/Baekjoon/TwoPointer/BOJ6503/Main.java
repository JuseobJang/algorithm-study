package Baekjoon.TwoPointer.BOJ6503;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            String str = br.readLine();
            int max = 0;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0, j = 0; i < str.length(); i++) {
                while (map.size() <= n && j < str.length()) {
                    char key = str.charAt(j);
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    } else {
                        if (map.size() == n) {
                            break;
                        } else {
                            map.put(key, 1);
                        }
                    }
                    j++;
                }

                int cnt = 0;
                for (int val : map.values()) {
                    cnt += val;
                }
                max = Math.max(cnt, max);

                char start = str.charAt(i);
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }

            }
            n = Integer.parseInt(br.readLine());
            bw.write(max + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}