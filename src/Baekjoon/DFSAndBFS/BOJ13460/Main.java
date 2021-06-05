package Baekjoon.DFSAndBFS.BOJ13460;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class ballInfo {
        int count;
        int rx, ry, bx, by;

        ballInfo(int a, int b, int c, int d, int e) {
            this.count = a;
            this.rx = b;
            this.ry = c;
            this.bx = d;
            this.by = e;
        }
    }

    static String[][] map;
    static int hx, hy, start_bx, start_by, start_rx, start_ry;
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // up , right , down , left

    static void bfs() {
        Queue<ballInfo> q = new LinkedList<ballInfo>();
        boolean[][][][] visit = new boolean[10][10][10][10];
        int ans = -1;

        ballInfo start = new ballInfo(0, start_rx, start_ry, start_bx, start_by);

        q.add(start);
        while (!q.isEmpty()) {
            ballInfo rb = q.poll();
            if (rb.count > 10) {
                break;
            }
            if (rb.rx == hx && rb.ry == hy) {
                ans = rb.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int rx = rb.rx;
                int ry = rb.ry;
                int bx = rb.bx;
                int by = rb.by;

                int[] r = tumble(rx, ry, i);
                int[] b = tumble(bx, by, i);

                rx = r[0];
                ry = r[1];
                bx = b[0];
                by = b[1];

                if (bx == hx && by == hy)
                    continue;
                if (rx == bx && ry == by) {
                    switch (i) {
                        case 0:
                            if (rb.rx < rb.bx)
                                rx--;
                            else
                                bx--;
                            break;
                        case 1:
                            if (rb.ry < rb.by)
                                ry--;
                            else
                                by--;
                            break;
                        case 2:
                            if (rb.rx < rb.bx)
                                bx++;
                            else
                                rx++;
                            break;
                        case 3:
                            if (rb.ry < rb.by)
                                by++;
                            else
                                ry++;
                            break;
                    }
                }
                if (!visit[rx][ry][bx][by]) {
                    visit[rx][ry][bx][by] = true;
                    ballInfo next = new ballInfo(rb.count + 1, rx, ry, bx, by);
                    q.add(next);
                }
            }
        }
        System.out.println(ans);
    }

    static int[] tumble(int x, int y, int i) {
        int[] a = new int[2];
        while (true) {
            x += dir[i][0];
            y += dir[i][1];
            if (map[x][y].equals("#")) {
                x -= dir[i][0];
                y -= dir[i][1];
                break;
            } else if (x == hx && y == hy) {
                break;
            }
        }
        a[0] = x;
        a[1] = y;
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("R")) {
                    start_rx = i;
                    start_ry = j;
                }
                if (map[i][j].equals("B")) {
                    start_bx = i;
                    start_by = j;
                }
                if (map[i][j].equals("O")) {
                    hx = i;
                    hy = j;
                }
            }
        }
        bfs();
        br.close();
    }
}
