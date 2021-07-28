//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/07/27.
//

import Foundation

class BOJ3649{
    static func main(){
        while let input = readLine() {
            let hole = Int(input)! * pow(10, 7)
            let n = Int(readLine()!)!
            var arr : [Int] = []
            var isDanger = true
            for _ in 0..<n{ arr.append(Int(readLine()!)!) }

            arr.sort()
            var i = 0;
            var j = n-1;
            while i < j {
                if arr[i] + arr[j] > hole { j -= 1 }
                else if arr[i] + arr[j] < hole { i += 1 }
                else { isDanger = false; break }
            }
            if isDanger { print("danger") }
            else { print("yes \(arr[i]) \(arr[j])") }
        }
    }

    static func pow(_ target: Int, _ count: Int) -> Int{
        var num = 1
        for _ in 0..<count{ num *= target }
        return num
    }
}
BOJ3649.main()
