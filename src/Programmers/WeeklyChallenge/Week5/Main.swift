import Foundation
import CoreFoundation

let fifth   = Int(pow(5.0,0.0))
let fourth  = Int(pow(5.0,1.0))
let third   = Int(pow(5.0,2.0))
let second  = Int(pow(5.0,3.0))
let first   = Int(pow(5.0,4.0))

let muls = [first + second + third + fourth + fifth,
            second + third + fourth + fifth,
            third + fourth + fifth,
            fourth + fifth,
            fifth]


func solution(_ word:String) -> Int {
    var cnt = 0
    for (index, char) in word.enumerated() {
        switch char {
            case "A" :
                cnt += muls[index] * 0 + 1
            case "E" :
                cnt += muls[index] * 1 + 1
            case "I" :
                cnt += muls[index] * 2 + 1
            case "O" :
                cnt += muls[index] * 3 + 1
            case "U" :
                cnt += muls[index] * 4 + 1
            default :
                break
        }
    }

    return cnt
}