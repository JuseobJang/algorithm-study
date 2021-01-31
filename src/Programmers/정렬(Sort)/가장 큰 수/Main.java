import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] a = { 5, 546 };

        System.out.println(sol.solution(a));
    }

}

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        Arrays.sort(nums);

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                int num1 = Integer.parseInt(sb1.append(o1).append(o2).toString());
                int num2 = Integer.parseInt(sb2.append(o2).append(o1).toString());
                if (num1 > num2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Arrays.sort(nums, comparator);

        StringBuilder sb = new StringBuilder();
        for (String s : nums) {
            sb.append(s);
        }
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}