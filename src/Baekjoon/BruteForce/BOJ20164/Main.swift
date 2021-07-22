//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/07/06.
//

import Foundation

class BOJ20164{
    static var max : Int = Int.min
    static var min : Int = Int.max
    static var isOdd: (Int) -> Bool = { a in
        return a % 2 == 1
    }
    
    static func main(){
        guard let input : String = readLine() else{
            return
        }
        dfs(nums : input, oddCount: 0)
        print(min, max)
    }
    
    static func dfs(nums : String, oddCount: Int){
        var curOddCount = oddCount
        if nums.count == 1{
            if(isOdd(Int(nums)!)){
                curOddCount += 1
            }
            max = Swift.max(max, curOddCount)
            min = Swift.min(min, curOddCount)
            return
            
        }else if nums.count == 2 {
            let arr : [Int] = numToArray(nums: nums)
            if(isOdd(arr[0])){curOddCount += 1}
            if(isOdd(arr[1])){curOddCount += 1}
            let result : String = String(arr[0] + arr[1])
            dfs(nums: result, oddCount: curOddCount)
        } else {
            let arr : [Int] = numToArray(nums: nums)
            for i in 0..<arr.count{
                if(isOdd(arr[i])){curOddCount += 1}
            }
            for i in 1..<arr.count - 1{
                for j in (i+1)..<arr.count{
                    var first : Int = 0
                    var second : Int = 0
                    var third : Int = 0
                    
                    for k in 0..<i{
                        first *= 10
                        first += arr[k]
                    }
                    for k in i..<j{
                        second *= 10
                        second += arr[k]
                    }
                    for k in j..<arr.count{
                        third *= 10
                        third += arr[k]
                    }
                    let total : Int = first + second + third
                    dfs(nums: String(total), oddCount: curOddCount)
                }
            }
            
        }
    }
    
    static func numToArray( nums : String ) -> [Int]{
        var arr : [Int] = []
        for i in 0..<nums.count {
            let char : Character = nums[nums.index(nums.startIndex, offsetBy: i)]
            arr.append(Int(String(char))!)
        }
        return arr
    }
}

BOJ20164.main()
