package Programmers.정렬.HIndex;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] a = { 4, 4, 4, 5, 0, 1, 2, 3 };

        System.out.println(sol.solution(a)); // 3

    }

}

class Solution {
    public int solution(int[] citations) {
        for (int i = citations.length; i >= 0; i--) {
            int cnt = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    cnt++;
                }
            }
            if (cnt >= i) {
                return i;
            }
        }
        return 0;
    }
}