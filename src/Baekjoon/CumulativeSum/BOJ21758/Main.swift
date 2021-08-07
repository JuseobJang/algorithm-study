//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/08/07.
//

import Foundation

class BOJ21758{
    static func main() {
        var input = readLine()!
        let n = Int(input)!

        input = readLine()!
        let honeys = input.components(separatedBy: " ").map{ Int($0)! }
        var cumSumRight = [Int](repeating: 0, count: n)
        var cumSumLeft = [Int](repeating: 0, count: n)
        for (index, honey) in honeys.enumerated() {
            if index == 0 {
                cumSumRight[index] = honey
            } else {
                cumSumRight[index] = cumSumRight[index - 1] + honey
            }
        }
        for (index, honey) in honeys.reversed().enumerated() {
            if index == 0 {
                cumSumLeft[index] = honey
            } else {
                cumSumLeft[index] = cumSumLeft[index - 1] + honey
            }
        }
        var ans = 0

        var fix = cumSumRight[n-1] - cumSumRight[0]
        for i in 1..<n {
            ans = Swift.max(ans, fix - honeys[i] + cumSumRight[n-1] - cumSumRight[i])
        }
        fix = cumSumLeft[n-1] - cumSumLeft[0]
        for i in 1..<n {
            ans = Swift.max(ans, fix - honeys[n-1-i] + cumSumLeft[n-1] - cumSumLeft[i])
        }
        for i in 1..<n-1 {
            ans = Swift.max(ans, cumSumLeft[n-1-i] - cumSumLeft[0] + cumSumRight[i] - cumSumRight[0])
        }
        print(ans)
    }
}

BOJ21758.main()
