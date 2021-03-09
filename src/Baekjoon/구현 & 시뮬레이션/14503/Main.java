import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int startRow;
    static int startCol;
    static int startFace; // 0 북 1 동 2 남 3 서
    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        startRow = Integer.parseInt(input[0]);
        startCol = Integer.parseInt(input[1]);
        startFace = Integer.parseInt(input[2]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        Cleaner cleaner = new Cleaner(startRow, startCol, startFace);
        bw.write(Integer.toString(cleaner.clean()));
        bw.flush();

        br.close();
        bw.close();

    }

    static class Cleaner {
        int ans;
        int row;
        int col;
        int face;
        boolean back;

        public Cleaner(int row, int col, int face) {
            this.ans = 0;
            this.row = row;
            this.col = col;
            this.face = face;
            this.back = false;
        }

        public int clean() {
            while (true) {
                cleanCur();
                checkAround();
                if (back) {
                    int preRow = row;
                    int preCol = col;
                    back();
                    if (preRow == row && preCol == col) {
                        return ans;
                    }
                } else {
                    go();
                }
            }
        }

        private void cleanCur() {
            if (map[row][col] == 0) {
                map[row][col] = 2;
                ans++;
            }
            return;
        }

        private void checkAround() { // 0 북 1 동 2 남 3 서
            for (int i = 0, nextFace = face + 3; i < 4; i++, nextFace += 3) {
                nextFace = nextFace % 4;
                int nextRow = row + dir[nextFace][0];
                int nextCol = col + dir[nextFace][1];
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                if (map[nextRow][nextCol] == 1 || map[nextRow][nextCol] == 2) {
                    continue;
                } else {
                    face = nextFace;
                    return;
                }
            }
            back = true;
            return;
        }

        private void go() {
            row = (row + dir[face][0]);
            col = (col + dir[face][1]);
            return;
        }

        private void back() {
            int nextRow = row + dir[(face + 2) % 4][0];
            int nextCol = col + dir[(face + 2) % 4][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                return;
            }
            if (map[nextRow][nextCol] == 1) {
                return;
            }
            row = nextRow;
            col = nextCol;
            back = false;
            return;
        }
    }
}
