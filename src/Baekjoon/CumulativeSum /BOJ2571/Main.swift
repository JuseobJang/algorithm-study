import Foundation

class BOJ2571{
    static var n: Int = 0

    static func main(){
        n = Int(readLine()!)!
        var sqares: [(row:Int, col:Int)] = []

        for _ in 0..<n {
            let input: String = readLine()!
            let row = Int(input.components(separatedBy: " ")[1])!
            let col = Int(input.components(separatedBy: " ")[0])!

            sqares.append((row, col))
        }

        var board = [[Int]](repeating: [Int](repeating: 0, count: 101), count: 101)

        for (row, col) in sqares{
            for r in row..<row+10 {
                for c in col..<col+10{
                    board[r][c] = 1
                }
            }
        }


        var rowBoard = [[Int]](repeating: [Int](repeating: 0, count: 101), count: 101)

        for c in 1...100 {
            for r in 1...100{
                if board[r][c] == 0 { continue }
                rowBoard[r][c] = rowBoard[r - 1][c] + 1
            }
        }

        var max = 0
        for r in 1...100{
            for c in 1...100{
                if board[r][c] == 0 { continue }
                var height = 100
                for width in 1...(100 - c + 1){
                    if board[r][c + width - 1] == 0 { break }
                    height = Swift.min(height, rowBoard[r][c + width - 1])
                    max = Swift.max(max, width * height)
                }
            }
        }
        print(max)
    }
}


BOJ2571.main()
