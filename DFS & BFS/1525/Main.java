import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // up , left, down, right
    static int puz = 0;

    static int bfs() {
        Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
        Queue<Integer> q = new LinkedList<>();
        visited.put(puz, 0);
        q.add(puz);

        while (!q.isEmpty()) {
            int num = q.poll();
            String strNum = String.valueOf(num);

            int start = strNum.indexOf("9");

            for (int i = 0; i < 4; i++) {
                StringBuilder sb = new StringBuilder(strNum);
                int row = start / 3;
                int col = start % 3;
                row = row + dir[i][0];
                col = col + dir[i][1];
                if (row < 0 || col < 0 || row >= 3 || col >= 3) {
                    continue;
                } else {
                    int newIndex = row * 3 + col;
                    char temp = strNum.charAt(newIndex);
                    sb.setCharAt(newIndex, '9');
                    sb.setCharAt(start, temp);
                    int newNum = Integer.parseInt(sb.toString());
                    if (!visited.containsKey(newNum)) {
                        visited.put(newNum, visited.get(num) + 1);
                        q.add(newNum);
                    }
                }
                if (visited.containsKey(123456789)) {
                    return visited.get(123456789);
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(input[j]);
                if (num == 0) {
                    num = 9;
                }
                puz = (10 * puz) + num;

            }
        }

        System.out.println(bfs());
    }
}
