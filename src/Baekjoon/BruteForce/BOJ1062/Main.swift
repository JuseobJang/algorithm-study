//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/07/07.
//

import Foundation

class BOJ1062{
    static var n : Int = 0
    static var k : Int = 0
    static var max : Int = 0
    static var words : [Int] = [Int](repeating: 0, count: n)
    static var visit : [Bool] = [Bool](repeating: false, count: 26)

    static func main(){
        var input: String

        input = readLine()!
        n = Int(input.components(separatedBy: " ")[0])!
        k = Int(input.components(separatedBy: " ")[1])!

        let base = 1<<0 + 1<<2 + 1<<8 + 1<<13 + 1<<19
        visit[0] = true
        visit[2] = true
        visit[8] = true
        visit[13] = true
        visit[19] = true

        for i in 0..<n{
            input = readLine()!
            for j in 0..<input.count{
                let c: Character = input[input.index(input.startIndex, offsetBy: j)]
                let val = c.asciiValue! - 97

                words[i] |= 1<<(val)
            }
        }

        if k < 5 {
            print(max)
            return
        }
        dfs(base: base,start: 0, depth: 0)
        print(max)
        return
    }

    static func dfs(base: Int, start: Int, depth:Int){
        if depth == k-5{
            var cnt: Int = 0
            for word in words{
                if(word | base == base){
                    cnt += 1
                }
            }
            max = Swift.max(max,cnt)
            return
        }

        for i in start..<26  {
            let newBase : Int = base | 1<<i
            if !visit[i] {
                visit[i] = true
                dfs(base: newBase,start:i ,depth: depth+1)
                visit[i] = false
            }
        }
    }
}

BOJ1062.main()

