package Baekjoon.Math.BOJ21275;

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
    static String a;
    static String b;
    static ArrayList<long[]> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        a = input[0];
        b = input[1];
    
        list = new ArrayList<long[]>();

        for (long i = 2; i <= 36; i++) {
            long newA = getNum(a, i);
            if (newA== -1 || newA >= Long.MAX_VALUE) {
                continue;
            }
            for(long j = 2; j <= 36; j++) {
                long newB = getNum(b, j);
                if (newB == -1 && newB >= Long.MAX_VALUE) {
                    continue;
                }
                if (newA == newB && i != j) {
                    long[] arr = { newA, i, j };
                    list.add(arr);
                }
            }
        }
        if (list.size() == 0) {
            bw.write("Impossible");
        } else if (list.size() == 1) {
            long[] arr = list.get(0);
            bw.write(Long.toString(arr[0]) + " " + Long.toString(arr[1]) + " " + Long.toString(arr[2]));
        } else {
            bw.write("Multiple");
        }

        bw.flush();

        br.close();
        bw.close();
        
        return;
    }

    static long getNum(String num, long k) {
        long ans = 0;
        for (int i = 0; i < num.length(); i++) {
            int c = num.charAt(i);
            if ( '0' <= c && c <= '9') {
                c -= 48;
                if (c >= k) {
                    return -1;
                }
            } if('a' <= c && c <= 'z') {
                c -= 87;
                if (c >= k) {
                    return -1;
                }
            }
            ans += c * Math.pow(k, num.length() - i - 1);
        }
        return ans;
    }
}
