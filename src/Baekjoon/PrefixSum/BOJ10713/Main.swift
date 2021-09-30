//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/07/07.
//

import Foundation

class BOJ10713{
    static func main(){
        guard let input = readLine() else{
            return
        }
        var inputArray = input.components(separatedBy: " ")
        let n: Int = Int(inputArray[0])!
        let m: Int = Int(inputArray[1])!

        guard let input = readLine() else {
            return
        }
        inputArray = input.components(separatedBy: " ")
        var path : [Int] = []
        for i in 0..<m{
            path.append(Int(inputArray[i])! - 1)
        }

        var costs : [[Int]] = [[Int]](repeating: [], count: n-1)
        for i in 0..<(n-1) {
            guard let input = readLine() else {
                return
            }
            inputArray = input.components(separatedBy: " ")
            costs[i].append(Int(inputArray[0])!)
            costs[i].append(Int(inputArray[1])!)
            costs[i].append(Int(inputArray[2])!)
        }

        var counts : [Int] = [Int](repeating: 0, count: n)
        for i in 0..<path.count-1 {
            let s : Int = Swift.min(path[i], path[i+1])
            let l : Int = Swift.max(path[i], path[i+1])

            counts[s] += 1
            counts[l] -= 1
        }
        var sum: Int = 0
        var w : Int = 0
        for i in 0..<n-1{
            w += counts[i]
            sum += Swift.min(costs[i][0] * w, costs[i][1] * w + costs[i][2])
        }
        print(sum)
    }
}


BOJ10713.main()
