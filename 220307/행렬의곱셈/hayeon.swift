import Foundation

func solution(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    var answer: [[Int]] = []
    
    for idx in 0..<arr1.count {
        var result: [Int] = []
        for i in 0..<arr2[0].count {
            var resultValue = 0
            for j in 0..<arr2.count {
                resultValue += arr1[idx][j] * arr2[j][i]
            }
            result.append(resultValue)
        }
        answer.append(result)
    }
    
    return answer
}
