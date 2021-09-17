import Foundation
import CoreFoundation

func solution(_ weights:[Int], _ head2head:[String]) -> [Int] {
    let cnt = weights.count

    var boxers: [Boxer] = []
    var winRates: [Double] = []
    var moreWeights: [Int] = []

    for i in 0..<cnt {
        boxers.append(Boxer(id: i + 1, weight: weights[i], records: []))
    }

    for i in 0..<cnt {
        var records: [Record] = []
        let results = head2head[i]
        for (idx, result) in results.enumerated() {
            records.append(Record(enemy: boxers[idx], result: String(result)))
        }
        boxers[i].records = records
    }

    for i in 0..<cnt {
        let winCnt = Double(boxers[i].records.filter{ record in record.result == "W"}.count)
        let totalCnt = Double(boxers[i].records.filter{ record in record.result != "N"}.count)
        boxers[i].winRate = winCnt / totalCnt * 100
    }

    for i in 0..<cnt {
        let moreWeightCnt = boxers[i].records.filter{ record in record.enemy.weight > boxers[i].weight && record.result == "W"}.count
        boxers[i].moreWeightWinCnt = moreWeightCnt
    }

    boxers.sort()

    var ans: [Int] = []
    for boxer in boxers {
        ans.append(boxer.id)
    }
    return ans
}

struct Record {
    let enemy: Boxer
    let result: String
}

struct Boxer: Comparable {
    let id: Int
    let weight: Int
    var records: [Record]
    var winRate: Double = 0.0
    var moreWeightWinCnt: Int = 0

    static func < (lhs: Boxer, rhs: Boxer) -> Bool {
        if lhs.winRate > rhs.winRate {
            return true
        } else if lhs.winRate < rhs.winRate {
            return false
        } else {
            if lhs.moreWeightWinCnt > rhs.moreWeightWinCnt {
                return true
            } else if lhs.moreWeightWinCnt < rhs.moreWeightWinCnt {
                return false
            } else {
                if lhs.weight > rhs.weight {
                    return true
                } else if lhs.weight < rhs.weight {
                    return false
                } else {
                    if lhs.id < rhs.id {
                        return true
                    } else {
                        return false
                    }
                }
            }
        }
    }

    static func == (lhs: Boxer, rhs: Boxer) -> Bool {
        lhs.id == rhs.id
    }
}