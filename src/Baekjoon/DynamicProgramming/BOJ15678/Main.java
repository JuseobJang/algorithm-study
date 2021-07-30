package Baekjoon.DynamicProgramming.BOJ15678;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int d = Integer.parseInt(input.split(" ")[1]);

        input = br.readLine();
        String[] inputs = input.split(" ");
        long[] arr = new long[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(inputs[i]);
        }

        Deque<pair> q = new LinkedList<pair>();
        long[] dp = new long[n];
        for(int i = 0 ; i < n ; i++){
            dp[i] = arr[i];
            while(!q.isEmpty() && q.peekFirst().index < i - d) q.removeFirst();
            if(!q.isEmpty()) dp[i] = Math.max(dp[i], q.getFirst().num + arr[i]);
            while (!q.isEmpty() && q.peekLast().num < dp[i]) q.removeLast();
            q.offerLast(new pair(i,dp[i]));
        }

        long max = Long.MIN_VALUE;
        for(long num : dp){
            max = Long.max(max, num);
        }
        System.out.println(max);
        bw.flush();
        br.close();
        bw.close();
    }
}

class pair{
    int index;
    long num;
    public pair(int index, long num){
        this.index = index;
        this.num = num;
    }
}
