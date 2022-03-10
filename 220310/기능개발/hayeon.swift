import Foundation

func solution(_ progresses:[Int], _ speeds:[Int]) -> [Int] {
    var completionArr: [Int] = []
    var answer: [Int] = []
    
    for (idx,progress) in progresses.enumerated() {
        var completion:Double = 0
        completion = ceil(Double(100-progress)/Double(speeds[idx]))
        completionArr.append(Int(completion))
    }
    
    while !completionArr.isEmpty {
        var cnt = 1
        var target = completionArr.removeFirst()
        for next in completionArr {
            if next <= target {
                cnt += 1
                completionArr.remove(at:0)
            }else {
                break
            }
        }
        answer.append(cnt)
    }
    
    return answer
}
