package Baekjoon.DFSAndBFS.BOJ16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.SizeSequence;

public class Main {
    static int N;
    static int[][] map;
    static int[][] visited;
    static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // up , left, down, right

    static class pos {
        int x;
        int y;
        int dis;

        pos(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static pos bfs(int row, int col, int size) {
        Queue<pos> q = new LinkedList<pos>();
        ArrayList<pos> find = new ArrayList<pos>();
        visited = new int[N][N];
        int find_dis = -1;

        q.add(new pos(row, col, 0));
        while (!q.isEmpty()) {
            pos p = q.poll();
            int dis = p.dis;
            for (int i = 0; i < 4; i++) {

                int next_row = p.x + dir[i][0];
                int next_col = p.y + dir[i][1];

                if (next_row < 0 || next_col < 0 || next_row >= N || next_col >= N) {
                    continue;
                }

                if (map[next_row][next_col] < size && map[next_row][next_col] != 0) {
                    visited[next_row][next_col] = 1;
                    if (find_dis == -1) {
                        find_dis = dis + 1;
                        find.add(new pos(next_row, next_col, dis + 1));
                    } else {
                        if (find_dis == dis + 1) {
                            find.add(new pos(next_row, next_col, dis + 1));

                        }
                    }
                } else if (map[next_row][next_col] == size || map[next_row][next_col] == 0) {
                    if (visited[next_row][next_col] == 0) {
                        visited[next_row][next_col] = 1;
                        q.add(new pos(next_row, next_col, dis + 1));
                    }
                }
            }
        }
        int min_x = 20;
        int min_y = 20;
        pos ans = null;
        for (pos a : find) {
            if (a.x < min_x) {
                min_x = a.x;
                ans = a;
                if (a.y < min_y) {
                    min_y = a.y;
                    ans = a;

                }
            }
        }
        if (ans != null) {
            map[ans.x][ans.y] = 0;
        }
        // System.out.println(ans.x + " " + ans.y);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int start_row = -1;
        int start_col = -1;
        int size = 2;
        int fish = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            String[] input_map = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input_map[j]);
                if (map[i][j] == 9) {
                    start_row = i;
                    start_col = j;
                    map[i][j] = 0;
                }

            }
        }

        pos next;
        while ((next = bfs(start_row, start_col, size)) != null) {
            fish++;
            if (fish == size) {
                fish = 0;
                size++;
            }
            start_row = next.x;
            start_col = next.y;
            ans += next.dis;

        }
        System.out.println(ans);

    }

}
