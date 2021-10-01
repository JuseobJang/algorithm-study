//
//  BOJ2559.swift
//  Algorithms
//
//  Created by seob_jj on 2021/10/01.
//

import Foundation

class BOJ2559 {
    static func main(){
        var input = readLine()!
        let N = Int(input.components(separatedBy: " ")[0])!
        let K = Int(input.components(separatedBy: " ")[1])!

        input = readLine()!
        let arr = input.components(separatedBy: " ").map { Int($0)! }
        var sum = [Int](repeating: 0, count: N - K + 1)
        for k in 0..<K {
            sum[0] += arr[k]
        }
        for i in 1..<(N - K + 1){
            sum[i] = sum[i - 1] + arr[i + K - 1] - arr[i - 1]
        }
        print(sum.max()!)
    }
}

BOJ2559.main()


