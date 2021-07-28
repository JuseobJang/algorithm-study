//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/07/27.
//

import Foundation

class BOJ14938{
    static let INF = 1_000_000

    static func main(){
        var input = readLine()!
        let n = Int(input.components(separatedBy: " ")[0])!
        let m = Int(input.components(separatedBy: " ")[1])!
        let r = Int(input.components(separatedBy: " ")[2])!

        input = readLine()!

        let items = input.components(separatedBy: " ").map{ Int($0)!}
        var matrix = [[Int]](repeating: [Int](repeating: INF, count: n), count: n)
        for i in 0..<n {
            matrix[i][i] = 0
        }

        for _ in 0..<r {
            input = readLine()!
            let node1 = Int(input.components(separatedBy: " ")[0])! - 1
            let node2 = Int(input.components(separatedBy: " ")[1])! - 1
            let cost = Int(input.components(separatedBy: " ")[2])!
            matrix[node1][node2] = cost
            matrix[node2][node1] = cost
        }

        // 모든 출발점으로 부터 모든 끝점까지 최단 경로 구하기
        for k in 0..<n {
            for i in 0..<n{
                for j in 0..<n{
                    matrix[i][j] = Swift.min(matrix[i][j], matrix[i][k] + matrix[k][j])
                }
            }
        }
        // 갈 수 있는 곳들의 아이템 합 구하기
        var ans = 0
        for i in 0..<n{
            var itemCnt = 0
            for j in 0..<n{
                if matrix[i][j] <= m {
                    itemCnt += items[j]
                }
            }
            ans = Swift.max(ans, itemCnt)
        }
        print(ans)
    }
}

BOJ14938.main()
