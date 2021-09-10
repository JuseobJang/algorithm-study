//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/09/10.
//

import Foundation

class BOJ10830 {
    static var n: Int = 0

    static func main(){
        var input = readLine()!
        n = Int(input.components(separatedBy: " ")[0])!
        let b: UInt = UInt(input.components(separatedBy: " ")[1])!
        var a: [[UInt]] = [[UInt]](repeating: [], count: n)

        for i in 0..<n {
            input = readLine()!
            for num in input.components(separatedBy: " ") {
                a[i].append(UInt(num)!)
            }
        }

        let ans = solve(mat: a, n: b)
        for i in 0..<n {
            for j in 0..<n{
                print("\(ans[i][j] % 1000)", terminator: " ")
            }
            print()
        }
    }

    static func solve(mat: [[UInt]], n: UInt) -> [[UInt]] {
        if n == 1 {
            return mat
        }
        let temp = solve(mat: mat, n: n/2)
        if n % 2 == 0 {
            return multiply(temp, temp)
        } else {
            return multiply(multiply(temp,temp), solve(mat: mat, n: 1))
        }
    }

    static func multiply(_ mat1:[[UInt]],_ mat2:[[UInt]]) -> [[UInt]]{
        var ret = [[UInt]](repeating: [UInt](repeating: 0, count: n), count: n)
        for i in 0..<n {
            for j in 0..<n{
                for k in 0..<n{
                    ret[i][j] += mat1[i][k] * mat2[k][j]
                }
            }
        }

        for i in 0..<n {
            for j in 0..<n{
                ret[i][j] %= 1000
            }
        }
        return ret
    }
}

BOJ10830.main()
