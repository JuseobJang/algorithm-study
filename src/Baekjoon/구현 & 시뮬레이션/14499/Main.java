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
    static int[] start = new int[2];
    static int k;
    static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // 동 서 북 남
    static int[][] map;
    static int[] cmd;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[4]);

        start[0] = Integer.parseInt(input[2]);
        start[1] = Integer.parseInt(input[3]);

        map = new int[n][m];
        cmd = new int[k];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            cmd[i] = Integer.parseInt(input[i]);
        }

        Dice dice = new Dice(start[0], start[1]);
        for (int go : cmd) {
            dice.roll(go - 1);
        }

        bw.flush();

        br.close();
        bw.close();

        return;
    }

    static class Dice {
        int curRow;
        int curCol;

        int top;
        int bottom;
        int east;
        int west;
        int north;
        int south;

        public Dice(int startRow, int startCol) {
            this.curRow = startRow;
            this.curCol = startCol;

            this.top = 0;
            this.bottom = 0;
            this.east = 0;
            this.west = 0;
            this.north = 0;
            this.south = 0;
        }

        public void roll(int go) throws IOException {
            if (curRow + dir[go][0] < 0 || curRow + dir[go][0] >= n || curCol + dir[go][1] < 0
                    || curCol + dir[go][1] >= m) {
                return;
            }
            curRow += dir[go][0];
            curCol += dir[go][1];
            
            int temp;
            switch (go) {
                case 0: // 동
                    temp = top;
                    top =west;
                    west = bottom;
                    bottom = east;
                    east = temp;
                    break;
                case 1: // 서
                    temp = top;
                    top = east;
                    east = bottom;
                    bottom = west;
                    west = temp;
                    break;
                case 2: // 북
                    temp = top;
                    top = south;
                    south = bottom;
                    bottom = north;
                    north = temp;
                    break;
                case 3: // 남
                    temp = top;
                    top = north;
                    north = bottom;
                    bottom = south;
                    south = temp;
                    break;
            }
            if(map[curRow][curCol]== 0){
                map[curRow][curCol] = bottom;
            }else{
                bottom = map[curRow][curCol];
                map[curRow][curCol] = 0;
            }

            bw.write(Integer.toString(top));
            bw.newLine();
            return;
        }
    }
}
