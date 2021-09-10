//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/09/10.
//

import Foundation

class BOJ17845{

    static var N: Int = 0 // 공부시간
    static var K: Int = 0 // 과목수

    static func main(){

        var input = readLine()!
        N = Int(input.components(separatedBy: " ")[0])!
        K = Int(input.components(separatedBy: " ")[1])!

        var dp: [[Int]] = [[Int]](repeating: [Int](repeating: 0, count: N+1), count: K+1)

        var courses: [Course] = []
        for _ in 0..<K {
            input = readLine()!
            let importance = Int(input.components(separatedBy: " ")[0])!
            let time = Int(input.components(separatedBy: " ")[1])!
            courses.append(Course(importance: importance, time: time))
        }

        //dp[i][j] = i번째 강의 까지 선택권과 j 라는 한계 공부시간을 가질 때, 최대 중요도

        for i in 1...K {
            for j in 1...N {
                // 넣을 수 없는 경우
                if courses[i-1].time > j {
                    // i-1 번째 까지 선택권이 있을 때와 중요도 최댓값이 같음
                    dp[i][j] = dp[i-1][j]
                // 넣을 수 있는 경우
                } else {
                    // i 번째를 안넣을 때 중요도 최댓값 또는
                    // i 번째를 강의 중요도 + (현재 한계 시간 - i번째 강의 시간)을 한계 시간으로 갖는 중요도의 최댓값
                    dp[i][j] =  max(dp[i-1][j], dp[i-1][j - courses[i-1].time] + courses[i-1].importance)
                }
            }
        }
        print(dp[K][N])
    }
}

struct Course{
    var importance: Int
    var time: Int
}

BOJ17845.main()

