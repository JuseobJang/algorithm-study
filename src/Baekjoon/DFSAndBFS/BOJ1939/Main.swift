//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/08/12.
//
import Foundation

class BOJ1939{
    static var n = 0
    static var m = 0
    static var start = 0
    static var end = 0
    static var bridges = [[Bridge]]()


    static func main(){
        var input: [String] = readLine()!.components(separatedBy: " ")
        n = Int(input[0])!
        m = Int(input[1])!
        bridges = [[Bridge]](repeating: [], count: n)

        var max = 0

        for _ in 0..<m {
            input = readLine()!.components(separatedBy: " ")
            let start = Int(input[0])! - 1
            let end = Int(input[1])! - 1
            let limit = Int(input[2])!

            max = max > limit ? max : limit

            bridges[start].append(Bridge(end: end, limit: limit))
            bridges[end].append(Bridge(end: start, limit: limit))
        }

        input = readLine()!.components(separatedBy: " ")
        start = Int(input[0])! - 1
        end = Int(input[1])! - 1

        print(binarySearch(max: max))
    }

    static func binarySearch(max: Int) -> Int{
        var left  = 1
        var right = max
        var mid = 0
        var ans = 0
        while(left <= right){
            mid = (left + right) / 2
            if bfs(start, end, mid){
                ans = mid > ans ? mid : ans
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return ans
    }

    static func bfs(_ start: Int, _ end: Int, _ weight: Int) -> Bool{
        var queue = [Int]()
        var visited = [Bool](repeating: false, count: n)
        queue.append(start)
        visited[start] = true

        while !queue.isEmpty {
            let cur = queue.removeLast()
            if( cur == end){
                return true
            }

            for bridge in bridges[cur] {
                if !visited[bridge.end] && bridge.limit >= weight {
                    queue.append(bridge.end)
                    visited[bridge.end] = true
                }
            }
        }
        return false
    }

}

struct Bridge{
    let end: Int
    let limit: Int
}

BOJ1939.main()
