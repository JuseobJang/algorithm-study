//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/09/30.
//

import Foundation

class BOJ3020{
    static func main(){
        var input = readLine()!
        let N = Int(input.components(separatedBy: " ")[0])!
        let H = Int(input.components(separatedBy: " ")[1])!

        var bottom = [Int](repeating: 0, count: H)
        var top = [Int](repeating: 0, count: H)

        for _ in 0..<N/2{
            input = readLine()!
            bottom[Int(input)! - 1] += 1
            input = readLine()!
            top[Int(input)! - 1] += 1
        }

        for i in (0..<H-1).reversed(){
            bottom[i] = bottom[i] + bottom[i+1]
            top[i] = top[i] + top[i+1]
        }

        let reversedTop = [Int](top.reversed())
        var results: [Int] = []
        for i in 0..<H {
            results.append( bottom[i] + reversedTop[i] )
        }

        var ans = Int.max
        var cnt = 0
        for result in results {
            if result > ans { continue }
            else if result < ans { ans = result; cnt = 1 }
            else { cnt += 1 }
        }
        print("\(ans) \(cnt)")
    }
}

BOJ3020.main()

