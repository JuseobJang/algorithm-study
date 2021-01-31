import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] copyMap;
    static ArrayList<pos> virus;
    static int max = 0;

    static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // up , left, down, right

    static class pos {
        public int row;
        public int col;

        pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    static void makeWall(pos start, int count) {
        if (count == 3) {
            copyMap = new int[N][M];
            copy();
            int safe = 0;
            Queue<pos> q = new LinkedList<pos>();
            Iterator<pos> iterator = virus.iterator();

            while (iterator.hasNext()) {
                pos a = iterator.next();
                q.add(a);
            }
            while (!q.isEmpty()) {
                pos v = q.poll();

                for (int i = 0; i < 4; i++) {
                    int row = v.row + dir[i][0];
                    int col = v.col + dir[i][1];
                    if (row < 0 || col < 0 || row >= N || col >= M) {
                        continue;
                    }
                    if (copyMap[row][col] == 0) {
                        copyMap[row][col] = 2;
                        q.add(new pos(row, col));
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] == 0) {
                        safe++;
                    }
                }
            }
            if (max < safe)
                max = safe;
            return;
        }
        int row = start.row;
        int col = start.col;

        if (row == N) {
            return;
        }
        if (col == M) {
            makeWall(new pos(row + 1, 0), count);
            return;
        }
        if (map[row][col] == 0) {
            map[row][col] = 1;
            makeWall(new pos(row, col + 1), count + 1);
            map[row][col] = 0;
        }
        makeWall(new pos(row, col + 1), count);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        virus = new ArrayList<pos>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 2) {
                    virus.add(new pos(i, j));
                }
            }
        }
        makeWall(new pos(0, 0), 0);
        System.out.println(max);
    }
}
