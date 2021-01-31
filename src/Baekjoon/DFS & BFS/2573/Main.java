import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<pair> queue = new LinkedList<pair>();

    static class pair {
        Integer key;
        Integer value;

        public pair(final Integer key, final Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getkey() {
            return key;
        }

        public Integer getvalue() {
            return value;
        }
    }

    static int[][] manyWater(int[][] ice, int row, int col) {
        int[][] water = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ice[i][j] == 0)
                    continue;
                else {
                    if (ice[i + 1][j] == 0)
                        water[i][j]++;
                    if (ice[i][j + 1] == 0)
                        water[i][j]++;
                    if (ice[i - 1][j] == 0)
                        water[i][j]++;
                    if (ice[i][j - 1] == 0)
                        water[i][j]++;
                }
            }
        }
        return water;
    }

    static pair findStart(int[][] ice, int row, int col) {
        pair pos;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (ice[i][j] != 0) {
                    pos = new pair(i, j);
                    return pos;
                }
            }
        }
        pos = new pair(0, 0);
        return pos;
    }

    static int search(int[][] ice, int row, int col) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ice[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static int breadthSearch(int[][] ice, int row, int col, int x, int y) {
        int iceCount = 0;
        int[][] breadth = new int[row][col];
        queue.clear();

        queue.add(new pair(x, y));
        while (!queue.isEmpty()) {
            pair node = queue.poll();
            int visitedX = node.getkey();
            int visitedY = node.getvalue();
            if (visitedX == 0 || visitedY == 0) {
                return -1;
            }
            iceCount++;
            breadth[visitedX][visitedY] = 1;
            if (ice[visitedX + 1][visitedY] != 0 && breadth[visitedX + 1][visitedY] == 0) {
                breadth[visitedX + 1][visitedY] = 1;
                queue.add(new pair(visitedX + 1, visitedY));
            }
            if (ice[visitedX][visitedY + 1] != 0 && breadth[visitedX][visitedY + 1] == 0) {
                breadth[visitedX][visitedY + 1] = 1;
                queue.add(new pair(visitedX, visitedY + 1));
            }
            if (ice[visitedX - 1][visitedY] != 0 && breadth[visitedX - 1][visitedY] == 0) {
                breadth[visitedX - 1][visitedY] = 1;
                queue.add(new pair(visitedX - 1, visitedY));
            }
            if (ice[visitedX][visitedY - 1] != 0 && breadth[visitedX][visitedY - 1] == 0) {
                breadth[visitedX][visitedY - 1] = 1;
                queue.add(new pair(visitedX, visitedY - 1));
            }
        }
        return iceCount;
    }

    static void subtract(int[][] ice, int[][] water, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ice[i][j] < water[i][j]) {
                    ice[i][j] = 0;

                } else {
                    ice[i][j] = ice[i][j] - water[i][j];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int[][] ice = new int[row][col];
        int year = 0;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                int height = Integer.parseInt(st.nextToken());
                ice[i][j] = height;
                if (height > 0) {
                }
            }
        }
        pair start = findStart(ice, row, col);
        int x = start.getkey();
        int y = start.getvalue();

        int bs;
        while ((bs = breadthSearch(ice, row, col, x, y)) == search(ice, row, col)) {
            subtract(ice, manyWater(ice, row, col), row, col);
            start = findStart(ice, row, col);
            x = start.getkey();
            y = start.getvalue();
            year++;
        }
        if (bs < 0) {
            System.out.println(0);
        } else {
            System.out.println(year);
        }
    }
}
