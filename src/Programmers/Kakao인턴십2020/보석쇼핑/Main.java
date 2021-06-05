package Programmers.Kakao인턴십2020.보석쇼핑;

import java.util.HashSet;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] a = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
        String[] b = { "AA", "AB", "AC", "AA", "AC" };
        String[] c = { "XYZ", "XYZ", "XYZ" };
        String[] d = { "DIA", "EM", "EM", "RUB", "DIA" };
        System.out.println(Arrays.toString(sol.solution(a)));// 7
        System.out.println(Arrays.toString(sol.solution(b))); // 9
        System.out.println(Arrays.toString(sol.solution(c))); // 9
        System.out.println(Arrays.toString(sol.solution(d))); // 9
    }

}

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> hs = new HashSet<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String s : gems) {
            hs.add(s);
        }
        int n = hs.size();
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (right < gems.length) {
            if (map.size() < n && right < gems.length) {
                int val = 0;
                if (map.containsKey(gems[right])) {
                    val = map.get(gems[right]);
                }
                map.put(gems[right], val + 1);
                right++;
            }
            while (map.size() == n) {
                int tmpLen = right - left;
                if (tmpLen < len) {
                    len = tmpLen;
                    answer[0] = left + 1;
                    answer[1] = right;
                    if (tmpLen == n) {
                        return answer;
                    }
                }
                int val = map.get(gems[left]);
                if (val > 1) {
                    map.put(gems[left], val - 1);
                } else {
                    map.remove(gems[left]);
                }
                left++;
            }
        }
        return answer;
    }
}