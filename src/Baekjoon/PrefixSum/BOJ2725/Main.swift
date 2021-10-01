//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/10/01.
//

import Foundation

class BOJ2725{
    static func main(){
        var arr = [Int](repeating: 0, count: 1001)
        for x in 0...1000{
            for y in 0..<x {
                if gcd(x, y) == 1 { arr[x] += 1 }
            }
        }

        let C = Int(readLine()!)!
        var tc = 0
        while tc < C {
            let N = Int(readLine()!)!
            var cnt = 0
            for n in 0...N {
                cnt += arr[n]
            }
            print(cnt * 2 + 1)
            tc += 1
        }
    }

    static func gcd(_ num1: Int, _ num2: Int) -> Int {
        var a = num1 ; var b = num2
        while(b != 0){
            let temp = b
            b = a % b
            a = temp
        }
        return a
    }
}

BOJ2725.main()
