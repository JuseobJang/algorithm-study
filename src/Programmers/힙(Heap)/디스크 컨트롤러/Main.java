import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        Solution sol = new Solution();

        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

        System.out.println(sol.solution(jobs));// 9
        // sol.solution(skoville, k);
    }
}

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        MinHeap minHeap = new MinHeap();

        int len = jobs.length;
        int cnt = 0;
        int end = 0;
        int i = 0;

        int answer = 0;

        while (cnt < len) {
            while (i < len && jobs[i][0] <= end) {
                minHeap.insert(jobs[i++]);
            }
            if (minHeap.size() == 0) {
                end = jobs[i][0];
            } else {
                int[] temp = minHeap.delete();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                cnt++;
            }
        }

        answer /= len;

        return answer;
    }
}

class MinHeap {
    private ArrayList<int[]> heap;

    public int size() {
        return this.heap.size() - 1;
    }

    public MinHeap() {
        this.heap = new ArrayList<int[]>();
        int[] zero = { 0, 0 };
        heap.add(zero);
    }

    public void insert(int[] arr) {
        heap.add(arr);
        int node = heap.size() - 1;
        while (node > 1 && heap.get(node)[1] < heap.get(node / 2)[1]) {
            int[] tmp = heap.get(node);
            heap.set(node, heap.get(node / 2));
            heap.set(node / 2, tmp);

            node /= 2;
        }
    }

    public int[] delete() {

        if (heap.size() - 1 == 1) {
            return heap.remove(1);
        }

        int[] root = heap.get(1);

        int[] tmpMax = heap.remove(heap.size() - 1);

        int parent = 1;
        int child = 2;

        while (child <= heap.size() - 1) {
            if (child + 1 < heap.size() && heap.get(child)[1] > heap.get(child + 1)[1]) {
                child++;
            }

            if (tmpMax[1] <= heap.get(child)[1]) {
                break;
            }
            heap.set(parent, heap.get(child));
            parent = child;
            child *= 2;
        }

        heap.set(parent, tmpMax);

        return root;
    }
}