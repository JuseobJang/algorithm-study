import Foundation

class BOJ1007{
    static var n = 0
    static var min = Double(Int.max)
    static var points: [pair] = []
    static var visited: [Bool] = []

    static func main(){
        let test = Int(readLine()!)!

        for _ in 0..<test{
            n = Int(readLine()!)!

            points = [pair](repeating: pair(x:0,y:0), count: n)
            visited = [Bool](repeating: false, count: n)

            for i in 0..<n{
                let input = readLine()!
                let x = Int(input.components(separatedBy: " ")[0])!
                let y = Int(input.components(separatedBy: " ")[1])!
                points[i] = pair(x: x, y: y)
            }

            dfs(idx:0,depth: 0)
            print(min)
            min = Double(Int.max)
        }
    }

    static func dfs(idx: Int, depth: Int){
        if idx == n {
            return
        }

        if depth == n/2 {

            var sumX : Int64 = 0
            var sumY : Int64 = 0
            for (i, point) in points.enumerated(){
                if visited[i] {
                    sumX += Int64(point.x)
                    sumY += Int64(point.y)
                }else{
                    sumX -= Int64(point.x)
                    sumY -= Int64(point.y)
                }
            }
            min = Swift.min(Double(min), getVectorSize(x: sumX, y: sumY))
            return
        }

        visited[idx] = true
        dfs(idx: idx+1,depth: depth+1)
        visited[idx] = false
        dfs(idx: idx+1, depth: depth)
        return
    }

    static func getVectorSize(x: Int64, y:Int64) -> Double {
        return sqrt( pow(Double(x), 2) + pow(Double(y), 2))
    }

}

struct pair{
    var x: Int
    var y: Int
    init(x: Int, y: Int) {
        self.x = x
        self.y = y
    }
}

BOJ1007.main()
