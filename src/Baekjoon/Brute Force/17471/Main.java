import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n;
    static int[] pop;
    static boolean[] grpA;
    static ArrayList<ArrayList<Integer>> list;

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        n = Integer.parseInt(br.readLine());

        pop = new int[n];
        grpA = new boolean[n];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            pop[i] = Integer.parseInt(input[i]);
        }

        list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            list.add(new ArrayList<Integer>());
            for (int j = 1; j < input.length; j++) {
                list.get(i).add(Integer.parseInt(input[j]) - 1);
            }
        }
        dfs(0);
        if (ans == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(ans));
        }
        bw.flush();

        br.close();
        bw.close();

    }

    static void dfs(int idx) {
        if (idx == n) {
            if (bfs()) {
                int sumA = 0, sumB = 0;
                for (int i = 0; i < n; i++) {
                    if (grpA[i]) {
                        sumA += pop[i];
                    } else {
                        sumB += pop[i];
                    }
                }
                ans = Math.min(ans, Math.abs(sumA - sumB));
            }
        } else {
            grpA[idx] = true;
            dfs(idx + 1);
            grpA[idx] = false;
            dfs(idx + 1);
        }
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        int a = -1;
        int b = -1;

        for (int i = 0; i < n; i++) {
            if (grpA[i]) {
                a = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!grpA[i]) {
                b = i;
                break;
            }
        }
        if (a == -1 || b == -1)
            return false;

        q.add(a);
        visited[a] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < list.get(cur).size(); i++) {
                int next = list.get(cur).get(i);
                if (visited[next])
                    continue;
                if (!grpA[next])
                    continue;
                visited[next] = true;
                q.add(next);
            }
        }
        q.add(b);
        visited[b] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < list.get(cur).size(); i++) {
                int next = list.get(cur).get(i);
                if (visited[next])
                    continue;
                if (grpA[next])
                    continue;
                visited[next] = true;
                q.add(next);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }
}
