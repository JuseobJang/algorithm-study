import Foundation

class BOJ2877{
    static func main(){
        var k = Int(readLine()!)!
        var len : Int = 1
        var start = 1
        var end = start * 2 + 1
        while !(start <= k && k < end) {
            len += 1
            start = end
            end = start * 2 + 1
        }
        k -= start
        var ans = [Int](repeating: 4, count: len)
        for i in (0..<len).reversed() {
            let r = k % 2
            if r == 1 {
                ans[i] = 7
            }
            k /= 2
        }
        for i in 0..<len {
            print(ans[i],terminator: "")
        }
    }
}

BOJ2877.main()
