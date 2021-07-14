import Foundation


class BOJ1022{
    static var r1 : Int = 0
    static var c1 : Int = 0
    static var r2 : Int = 0
    static var c2 : Int = 0
    static let dir = [[0,1],[-1,0],[0,-1],[1,0]]

    static func main(){
        var input = readLine()!
        r1 = Int(input.components(separatedBy: " ")[0])!
        c1 = Int(input.components(separatedBy: " ")[1])!
        r2 = Int(input.components(separatedBy: " ")[2])!
        c2 = Int(input.components(separatedBy: " ")[3])!

        var x = -r1
        var y = -c1

        r2 = r2 - r1
        c2 = c2 - c1
        r1 = 0
        c1 = 0

        var tornado = [[Int]](repeating:[Int](repeating: 0, count: c2 + 1), count: r2 + 1)
        var d = -1
        var cnt = -1
        var dcnt = 0
        var num = 1
        while true {
            if x >= r1 && x <= r2 && y >= c1 && y <= c2 {
                tornado[x][y] = num
            }
            cnt += 1
            if cnt == dcnt{
                d = (d + 1) % 4
                cnt = 0
                if d == 0 || d == 2 {
                    dcnt += 1
                }
            }
            x += dir[d][0]
            y += dir[d][1]
            num += 1

            if tornado[r1][c1] != 0 && tornado[r1][c2] != 0 && tornado[r2][c1] != 0 && tornado[r2][c2] != 0{
                break
            }
        }
        var len = 0
        for row in tornado{
            for num in row{
                len = Swift.max(len, String(num).count)
            }
        }
        for row in tornado{
            for num in row{
                print(String(format: "%\(len)d", num), terminator: " ")
            }
            print()
        }
    }
}

BOJ1022.main()
