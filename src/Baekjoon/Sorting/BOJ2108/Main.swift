//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/08/12.
//

import Foundation

class BOJ2108{
    static var n = 0

    static func main(){
        n = Int(readLine()!)!
        var arr = [Int]()
        for _ in 0..<n{
            arr.append(Int(readLine()!)!)
        }
        arr.sort()
        var sum: Double = 0
        var dict = [Int : Int]()
        var maxCount = 0

        for a in arr {
            sum += Double(a)
            dict[a] = (dict[a] ?? 0) + 1
            maxCount = dict[a]! > maxCount ? dict[a]! : maxCount
        }

        let freq = dict.filter{ $0.value == maxCount }

        let mean = Int(round(sum / Double(n)))
        let median = arr[n / 2]
        let mode = freq.sorted{ $0.key < $1.key}[freq.count > 1 ? 1 : 0].key
        let range = arr.last! - arr.first!

        print(mean)
        print(median)
        print(mode)
        print(range)
    }
}

BOJ2108.main()