import Foundation

func solution(_ enter:[Int], _ leave:[Int]) -> [Int] {

    let count = enter.count
    var ans: [Int] = [Int](repeating: 0, count: count)

    var zoom: Set<Int> = []

    var enterIdx = 0
    var leaveIdx = 0

    while leaveIdx < count {
        if zoom.contains(leave[leaveIdx]){
            zoom.remove(leave[leaveIdx])
            leaveIdx += 1
            continue
        }
        if !zoom.contains(enter[enterIdx]){
            for member in zoom {
                ans[member - 1] += 1
            }
            ans[enter[enterIdx] - 1] = zoom.count
            zoom.insert(enter[enterIdx])
            enterIdx += 1
        }
    }
    return ans
}