package Programmers.CodeChallengeSeason1.스타수열

import java.util.Collections.sort
import kotlin.collections.HashMap
import kotlin.math.max


class Solution {
    fun solution(a: IntArray): Int {
        var max: Int = -1
        var count: IntArray = IntArray(a.size)
        for (i in a) {
            count[i]++
        }
        for (key in count.indices) {
            if (count[key] * 2 <= max) {
                continue
            }
            var idx: Int = 0;
            var result: Int = 0;
            while (idx < a.size - 1) {
                if (a[idx] != key && a[idx + 1] != key) {
                    idx++
                    continue
                }
                if (a[idx] == a[idx + 1]) {
                    idx++
                    continue
                }
                idx += 2
                result += 2
            }
            max = max(result, max)
        }
        return when (max) {
            -1 -> 0;
            else -> max;
        }
    }

}
fun main(args: Array<String>) {
    val sol = Solution()
    val a: IntArray = intArrayOf(0, 3, 3, 0, 7, 2, 0, 2, 2, 0)
    println(sol.solution(a))
}