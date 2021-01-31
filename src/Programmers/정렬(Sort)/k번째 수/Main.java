import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] a = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] b = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

        System.out.println(Arrays.toString(sol.solution(a, b)));// {5,6,3}

    }

}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int pick = commands[i][2];
            int[] newArray = new int[end - start + 1];
            for (int j = 0, k = start; j < (end - start + 1); j++, k++) {
                newArray[j] = array[k - 1];
            }
            Arrays.sort(newArray);
            answer[i] = newArray[pick - 1];
        }
        return answer;
    }
}