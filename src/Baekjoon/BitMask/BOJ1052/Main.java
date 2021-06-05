package Baekjoon.BitMask.BOJ1052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        int bot = count(n);
        int ans = 0;
        while(bot > k){
             n++;
             ans++;
             bot = count(n);
        }
        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();

    }

    static int count(int n){
        int i=0;
        while(n != 0){
            n &= (n-1);
            i++;
        }
        return i;
    }
}
