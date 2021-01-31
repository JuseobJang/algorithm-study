public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(10, 2));// [4,3]
        System.out.println(sol.solution(8, 1)); // [3,3]
        System.out.println(sol.solution(24, 24)); // [8,6]
    }

}

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = yellow; i >= 1; i--) {
            if (yellow % i == 0) {
                int j = yellow / i;
                if (((2 * i) + (2 * j) + 4) == brown) {
                    int ans[] = { i + 2, j + 2 };
                    return ans;
                }
            }
        }
        int[] fail = { 0 };
        return fail;
    }
}