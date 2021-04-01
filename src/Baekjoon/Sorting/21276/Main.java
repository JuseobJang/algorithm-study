import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static String[] people;
    static HashMap<String, Integer> map;
    static int[][] des;
    static int[] asc;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        people = new String[n];
        people = br.readLine().split(" ");
        Arrays.sort(people);
        map = new HashMap<String, Integer>();
        des = new int[n][n];
        asc = new int[n];

        for (int i = 0; i < n; i++) {
            map.put(people[i], i);
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int parent = map.get(input[1]);
            int child = map.get(input[0]);
            des[parent][child] = 1;
            asc[child]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        int cnt = 0;
        for (int i = 0; i < people.length; i++) {
            if (asc[i] == 0) {
                cnt++;
            }
        }
        bw.write(Integer.toString(cnt));
        bw.newLine();

        for (int i = 0; i < people.length; i++) {
            if (asc[i] == 0) {
                q.add(i);
                bw.write(people[i] + " ");
            }
        }
        bw.newLine();

        while (!q.isEmpty()) {
            int par = q.poll();
            for (int i = 0; i < n; i++) {
                if (des[par][i] == 1) {
                    asc[i]--;
                    if (asc[i] == 0) {
                        q.add(i);
                    } else {
                        des[par][i] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int size = 0;
            for (int j = 0; j < n; j++) {
                if (des[i][j] == 1)
                    size++;
            }
            bw.write(people[i] + " " + size + " ");
            for (int j = 0; j < n; j++) {
                if (des[i][j] == 1)
                    bw.write(people[j] + " ");
            }
            bw.newLine();
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
