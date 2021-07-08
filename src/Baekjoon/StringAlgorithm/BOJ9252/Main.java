package Baekjoon.StringAlgorithm.BOJ9252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] lcs = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int len = lcs[str1.length()][str2.length()];
        int i = str1.length();
        int j = str2.length();
        while (len != 0) {
            if (lcs[i - 1][j] == len) {
                i--;
            } else if (lcs[i][j - 1] == len) {
                j--;
            } else {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
                len--;
            }
        }
        sb.reverse();
        int ans = lcs[str1.length()][str2.length()];
        bw.write(ans + "\n");
        if (ans != 0) {
            bw.write(sb.toString() + "\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}