package Programmers.KakaoBlindRecruitment2020.문자열압축;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("aabbaccc"));// 7
        System.out.println(sol.solution("ababcdcdababcdcd")); // 9
        System.out.println(sol.solution("abcabcdede")); // 8
        System.out.println(sol.solution("abcabcabcabcdededededede")); // 14
        System.out.println(sol.solution("xababcdcdababcdcd")); // 17
    }

}

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int lastIndex = s.length();
            for (int j = 0; j + i <= s.length();) {
                String p = s.substring(j, j + i);
                int pren = 0;
                while (j + i <= s.length() && p.equals(s.substring(j, j + i))) {
                    pren++;
                    j = j + i;
                }
                if (j + i > s.length()) {
                    lastIndex = j;
                }
                if (pren != 1) {
                    sb.append(Integer.toString(pren));
                }
                sb.append(p);
            }
            sb.append(s.substring(lastIndex));
            answer = Math.min(sb.toString().length(), answer);
        }
        return answer;
    }
}
