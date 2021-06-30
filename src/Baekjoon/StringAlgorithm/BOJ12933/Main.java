package Baekjoon.StringAlgorithm.BOJ12933;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer>[] duck = new ArrayList[500];
        for (int i = 0; i < 500; i++) {
            duck[i] = new ArrayList<Integer>();
        }
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'q') {
                for (int j = 0; j < 500; j++) {
                    if (duck[j].isEmpty() || duck[j].get(duck[j].size() - 1) == 'k') {
                        duck[j].add((int) c);
                        break;
                    }
                }
            } else if (c == 'u') {
                for (int j = 0; j < 500; j++) {
                    if (duck[j].isEmpty()) {
                        bw.write("-1\n");
                        bw.flush();
                        br.close();
                        bw.close();
                        return;
                    }
                    if (duck[j].get(duck[j].size() - 1) == 'q') {
                        duck[j].add((int) c);
                        break;
                    }
                }
            } else if (c == 'a') {
                for (int j = 0; j < 500; j++) {
                    if (duck[j].isEmpty()) {
                        bw.write("-1\n");
                        bw.flush();
                        br.close();
                        bw.close();
                        return;
                    }

                    if (duck[j].get(duck[j].size() - 1) == 'u') {
                        duck[j].add((int) c);
                        break;
                    }
                }
            } else if (c == 'c') {
                for (int j = 0; j < 500; j++) {
                    if (duck[j].isEmpty()) {
                        bw.write("-1\n");
                        bw.flush();
                        br.close();
                        bw.close();
                        return;
                    }
                    if (duck[j].get(duck[j].size() - 1) == 'a') {
                        duck[j].add((int) c);
                        break;
                    }
                }
            } else {
                for (int j = 0; j < 500; j++) {
                    if (duck[j].isEmpty()) {
                        bw.write("-1\n");
                        bw.flush();
                        br.close();
                        bw.close();
                        return;
                    }
                    if (duck[j].get(duck[j].size() - 1) == 'c') {
                        duck[j].add((int) c);
                        break;
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 500; i++) {
            if (duck[i].isEmpty()) {
                break;
            }
            if (duck[i].get(duck[i].size() - 1) != 'k') {
                bw.write("-1\n");
                bw.flush();
                br.close();
                bw.close();
                return;
            }
            cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}