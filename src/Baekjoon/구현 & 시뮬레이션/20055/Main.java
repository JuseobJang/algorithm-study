import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int k;
    static int[] belt;
    static int[] isRobot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;
        input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        belt = new int[2 * n];
        isRobot = new int[2 * n];

        input = br.readLine().split(" ");
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(input[i]);
        }

        int stage = 0;
        while (true) {
            moveBelt();
            moveRobot();
            stage++;
            if (zeroCount() >= k) {
                break;
            }
        }
        bw.write(Integer.toString(stage));
        bw.flush();

        br.close();
        bw.close();
    }
    public static void moveBelt() {
        int tmp = belt[2 * n - 1];
        int tmp1 = isRobot[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
            isRobot[i] = isRobot[i - 1];
            if (i >= n) {
                isRobot[i] = 0;
            }
        }
        belt[0] = tmp;
        isRobot[0] = tmp1;
    }
    public static void moveRobot() {
        isRobot[n - 1] = 0;
        for (int i = n - 1; i > 0; i--) {
            if (belt[i] > 0 && isRobot[i] == 0) {
                if (isRobot[i - 1] == 1) {
                    isRobot[i] = isRobot[i - 1];
                    isRobot[i - 1] = 0;
                    belt[i]--;
                }
            }
        }
        if (isRobot[0] == 0 && belt[0] > 0) {
            isRobot[0] = 1;
            belt[0]--;
        }
    }
    public static int zeroCount() {
        int cnt = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (belt[i] == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
