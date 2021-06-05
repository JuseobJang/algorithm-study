package Programmers.KakaoBlindRecruitment2021.합승택시요금;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] fares1 = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
                { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

        int[][] fares2 = { { 5, 7, 9 }, { 4, 6, 4 }, { 3, 6, 1 }, { 3, 2, 3 }, { 2, 1, 6 } };

        int[][] fares3 = { { 2, 6, 6 }, { 6, 3, 7 }, { 4, 6, 7 }, { 6, 5, 11 }, { 2, 5, 12 }, { 5, 3, 20 }, { 2, 4, 8 },
                { 4, 3, 9 } };

        System.out.println(sol.solution(6, 4, 6, 2, fares1)); // 82
        System.out.println(sol.solution(7, 3, 4, 1, fares2)); // 14
        System.out.println(sol.solution(6, 4, 5, 6, fares3)); // 18
    }
}

class Solution {
    final int INF = 1_000_000_000;
    long[][] dist;

    public long solution(int n, int s, int a, int b, int[][] fares) {
        dist = new long[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    continue;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        for (int[] fare : fares) {
            int v = fare[0];
            int u = fare[1];
            int w = fare[2];
            dist[v][u] = w;
            dist[u][v] = w;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long min = dist[s][a] + dist[s][b];

        for (int k = 1; k < n + 1; k++) {
            min = Math.min(min, dist[s][k] + dist[k][a] + dist[k][b]);
        }
        return min;
    }
}