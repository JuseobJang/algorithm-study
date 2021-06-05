package Programmers.완전탐색.소수찾기;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("17"));// 7 17 71 => 3
        System.out.println(sol.solution("011")); // 11 101 => 2
    }

}

class Solution {
    class pair {
        int key;
        boolean visited;

        public pair(int key, boolean visited) {
            this.key = key;
            this.visited = visited;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setVisted(boolean visited) {
            this.visited = visited;
        }

        public int getKey() {
            return key;
        }

        public boolean getVisited() {
            return visited;
        }
    }

    public int solution(String s) {
        String[] input = s.split("");
        pair[] nums = new pair[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = new pair(Integer.parseInt(input[i]), false);
        }
        HashSet<Integer> set = new HashSet<>();

        dfs(nums, 0, set);
        return set.size();
    }

    boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    void dfs(pair[] nums, int num, HashSet<Integer> set) {
        for (pair p : nums) {
            if (p.getVisited() == false) {
                p.setVisted(true);
                if (isPrime(num + p.getKey()))
                    set.add(num + p.getKey());
                dfs(nums, (num + p.getKey()) * 10, set);
                p.setVisted(false);
            }
        }
    }
}
