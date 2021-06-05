package Programmers.이분탐색.입국심사;

import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] times = { 7, 10 };
        System.out.println(sol.solution(6, times));
    }
}

class Solution {
    int[] times;
    long n;

    public long solution(int n, int[] times) {
        this.n = (long) n;
        this.times = times;
        Arrays.sort(times);
        return binarySearch();
    }

    public long binarySearch() {
        long maxTime = (long) times[times.length - 1];

        long left = times[0];
        long right = maxTime * n;
        long mid = 0;
        long ans = Long.MAX_VALUE;

        while (left <= right) {
            mid = (left + right) / 2;
            if (isPromise(mid)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPromise(long time) {
        long personCnt = 0;
        for (int i = 0; i < times.length; i++) {
            personCnt += time / times[i];
        }
        if (personCnt >= n)
            return true;
        else
            return false;
    }
}