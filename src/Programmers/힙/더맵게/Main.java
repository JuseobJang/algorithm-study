package Programmers.힙.더맵게;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int k = 7;

        System.out.println(sol.solution(scoville, k));// 2
        // sol.solution(skoville, k);

    }
}

class Solution {
    public int solution(int[] scoville, int k) {
        MinHeap minHeap = new MinHeap(scoville);
        if (minHeap.get(1) >= k) {
            return 0;
        }
        int cnt = 0;
        while (minHeap.size() > 2) {
            if (minHeap.mixScv() >= k) {
                cnt++;
                return cnt;
            } else {
                cnt++;
            }
        }
        return -1;
    }
}

class MinHeap {
    private ArrayList<Integer> heap;

    public int get(int index) {
        return this.heap.get(index);
    }

    public int size() {
        return this.heap.size();
    }

    public MinHeap(int[] nums) {
        this.heap = new ArrayList<Integer>();
        heap.add(0);
        for (int num : nums) {
            insert(num);
        }
    }

    public void insert(int val) {
        heap.add(val);
        int node = heap.size() - 1;
        while (node > 1 && heap.get(node) < heap.get(node / 2)) {
            int tmp = heap.get(node);
            heap.set(node, heap.get(node / 2));
            heap.set(node / 2, tmp);

            node /= 2;
        }
    }

    public int delete() {

        if (heap.size() - 1 == 1) {
            return heap.remove(1);
        }

        int root = heap.get(1);

        int tmpMax = heap.remove(heap.size() - 1);

        int parent = 1;
        int child = 2;

        while (child <= heap.size() - 1) {
            if (child + 1 < heap.size() && heap.get(child) > heap.get(child + 1)) {
                child++;
            }

            if (tmpMax <= heap.get(child)) {
                break;
            }
            heap.set(parent, heap.get(child));
            parent = child;
            child *= 2;
        }

        heap.set(parent, tmpMax);

        return root;
    }

    public int mixScv() {
        int a = delete();
        int b = delete();

        int mix = a + (b * 2);
        insert(mix);

        return heap.get(1);
    }
}