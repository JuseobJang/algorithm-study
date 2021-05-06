import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("100-200*300-500+20"));// 7
        System.out.println(sol.solution("50*6-3*2")); // 9
    }

}

class Solution {
    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> ops = new ArrayList<String>();
        ArrayList<Long> nums = new ArrayList<Long>();
        Long max = Long.MIN_VALUE;

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '*') {
                nums.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
                ops.add("*");
            } else if (expression.charAt(i) == '+') {
                nums.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
                ops.add("+");
            } else if (expression.charAt(i) == '-') {
                nums.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
                ops.add("-");
            } else {
                sb.append(expression.charAt(i));
            }
        }
        nums.add(Long.parseLong(sb.toString()));

        ArrayList<String> operations;
        ArrayList<Long> numbers;

        operations = (ArrayList<String>) ops.clone();
        numbers = (ArrayList<Long>) nums.clone();
        calc("*", operations, numbers);
        calc("+", operations, numbers);
        calc("-", operations, numbers);
        max = Math.max(Math.abs(numbers.get(0)), max);

        operations = (ArrayList<String>) ops.clone();
        numbers = (ArrayList<Long>) nums.clone();
        calc("*", operations, numbers);
        calc("-", operations, numbers);
        calc("+", operations, numbers);
        max = Math.max(Math.abs(numbers.get(0)), max);

        operations = (ArrayList<String>) ops.clone();
        numbers = (ArrayList<Long>) nums.clone();
        calc("+", operations, numbers);
        calc("*", operations, numbers);
        calc("-", operations, numbers);
        max = Math.max(Math.abs(numbers.get(0)), max);

        operations = (ArrayList<String>) ops.clone();
        numbers = (ArrayList<Long>) nums.clone();
        calc("+", operations, numbers);
        calc("-", operations, numbers);
        calc("*", operations, numbers);
        max = Math.max(Math.abs(numbers.get(0)), max);

        operations = (ArrayList<String>) ops.clone();
        numbers = (ArrayList<Long>) nums.clone();
        calc("-", operations, numbers);
        calc("*", operations, numbers);
        calc("+", operations, numbers);
        max = Math.max(Math.abs(numbers.get(0)), max);

        operations = (ArrayList<String>) ops.clone();
        numbers = (ArrayList<Long>) nums.clone();
        calc("-", operations, numbers);
        calc("+", operations, numbers);
        calc("*", operations, numbers);
        max = Math.max(Math.abs(numbers.get(0)), max);

        return max;
    }

    public void calc(String op, ArrayList<String> ops, ArrayList<Long> nums) {
        while (ops.contains(op)) {
            int i = ops.indexOf(op);
            int j = ops.indexOf(op);
            if (op.equals("+")) {
                nums.set(i, nums.get(j) + nums.get(j + 1));
                ops.remove(i);
                nums.remove(j + 1);
            }
            if (op.equals("*")) {
                nums.set(i, nums.get(j) * nums.get(j + 1));
                ops.remove(i);
                nums.remove(j + 1);
            }
            if (op.equals("-")) {
                nums.set(i, nums.get(j) - nums.get(j + 1));
                ops.remove(i);
                nums.remove(j + 1);
            }
        }
    }
}