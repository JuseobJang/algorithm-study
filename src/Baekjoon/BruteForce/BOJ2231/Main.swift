//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/08/07.
//

import Foundation

class BOJ2231{
    static func main() {
        let input = readLine()!
        let limit = input.count * 9
        let num = Int(input)!
        print(solution(num, limit))
    }
    static func solution(_ num: Int, _ limit: Int) -> Int{
        for i in (0...limit).reversed() {
            var n = num - i
            var sum: Int = n
            while n != 0{
                let digit = n % 10
                n /= 10
                sum += digit
            }
            if sum == num {
                return num - i
            }
        }
        return 0
    }
}
BOJ2231.main()
