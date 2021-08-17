//
//  main.swift
//  Algorithms
//
//  Created by seob_jj on 2021/08/07.
//

import Foundation

class BOJ1302{

    static func main(){
        let n = Int(readLine()!)!
        var dict: [String : Int] = [:]
        for _ in 0..<n {
            let book = readLine()!
            if let count = dict[book] {
                dict[book] = count + 1
            } else {
                dict[book] = 1
            }
        }
        let sortedDict = dict.sorted{ dict1 , dict2 in
            if dict1.value == dict2.value{
                return dict1.key < dict2.key
            } else {
                return dict1.value > dict2.value
            }
        }[0]
        print(sortedDict.key)
    }
}
BOJ1302.main()
