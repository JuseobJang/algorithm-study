import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(input[i]);
        }

        int t = Integer.parseInt(br.readLine());
        int lastAns = 0;

        MergeSortTree mst = new MergeSortTree(n, arr);
        mst.init(1, 1, n);

        for (int test = 0; test < t; test++) {
            String[] input1 = br.readLine().split(" ");
            int i = Integer.parseInt(input1[0]) ^ lastAns;
            int j = Integer.parseInt(input1[1]) ^ lastAns;
            int k = Integer.parseInt(input1[2]) ^ lastAns;

            lastAns = mst.query(1, 1, n, i, j, k);
            System.out.println(lastAns);
        }
    }
}

class MergeSortTree {
    ArrayList<Integer>[] tree;
    int[] arr;

    public MergeSortTree(int n, int arr[]) {
        n = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        n = (int) Math.pow(2, n);

        this.arr = arr;
        this.tree = new ArrayList[n];
    }

    public void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = new ArrayList<Integer>();
            tree[node].add(arr[start]);
        } else {
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            merge(node, tree[node * 2], tree[node * 2 + 1]);
        }
    }

    private void merge(int node, ArrayList<Integer> left, ArrayList<Integer> right) {

        tree[node] = new ArrayList<Integer>();
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                tree[node].add(left.get(i++));
            } else {
                tree[node].add(right.get(j++));
            }
        }
        if (i < left.size()) {
            while (i < left.size()) {
                tree[node].add(left.get(i++));
            }
        } else {
            while (j < right.size()) {
                tree[node].add(right.get(j++));
            }
        }
    }

    public int query(int node, int start, int end, int left, int right, int val) {
        if (right < start || left > end)
            return 0;
        else if (left <= start && end <= right) {
            return upperBound(node, val);
        } else {
            int leftAns = query(node * 2, start, (start + end) / 2, left, right, val);
            int rightAns = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right, val);
            return leftAns + rightAns;
        }
    }

    private int upperBound(int node, int val) {
        int size = tree[node].size();
        int start = 0, end = size;
        while (start < end) {
            int mid = (start + end) / 2;
            if (tree[node].get(mid) <= val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return size - end;
    }
}
