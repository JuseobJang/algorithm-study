import Foundation

class BOJ1743{
    static let dirs = [[0,1],[-1,0],[0,-1],[1,0]]

    static func main(){
        var input: String = readLine()!
        let r: Int = Int(input.components(separatedBy: " ")[0])!
        let c: Int = Int(input.components(separatedBy: " ")[1])!
        let k: Int = Int(input.components(separatedBy: " ")[2])!

        var trash: [[Bool]] = [[Bool]](repeating: [Bool](repeating: false, count: c), count: r)

        for _ in 0..<k {
            input = readLine()!
            let row: Int = Int(input.components(separatedBy: " ")[0])! - 1
            let col: Int = Int(input.components(separatedBy: " ")[1])! - 1
            trash[row][col] = true
        }

        print(bfs(trash: trash, row: r, col: c))
    }

    static func bfs(trash: [[Bool]], row: Int, col: Int) -> Int {

        var max = Int.min

        for r in 0..<row {
            for c in 0..<col{
                if !trash[r][c] { continue }
                var visited: [[Bool]] = [[Bool]](repeating: [Bool](repeating: false, count: col), count: row)
                var queue: [pair] = [pair(r,c)]
                var cnt = 0;
                while !queue.isEmpty {
                    let cur = queue.removeFirst()
                    if visited[cur.row][cur.col] { continue }
                    visited[cur.row][cur.col] = true
                    cnt += 1
                    for dir in dirs {
                        let next = pair(cur.row + dir[0], cur.col + dir[1])
                        if next.row < 0 || next.row >= row || next.col < 0 || next.col >= col { continue }
                        if !trash[next.row][next.col] { continue }
                        queue.append(next)
                    }
                }
                max = Swift.max(cnt, max)
            }
        }
        return max
    }
}

struct pair {
    var row: Int
    var col: Int
    init(_ row: Int, _ col: Int) {
        self.row = row
        self.col = col
    }
}

BOJ1743.main()