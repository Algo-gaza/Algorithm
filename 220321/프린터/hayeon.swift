import Foundation

func solution(_ priorities:[Int], _ location:Int) -> Int {
    var waitPrintDic: [Int:Int] = [:]
    var endPrintDic = Array<(key: Int, value: Int)>()
    var answer: Int = 1 // 몇번째 프린터 됬는지 
    
    // 대기목록 초기화 
    for (idx,priority) in priorities.enumerated() {
        waitPrintDic[idx] = priority
    }
    var sortedWaitPrintDic = waitPrintDic.sorted( by: < )

    while !sortedWaitPrintDic.isEmpty {
        let target = sortedWaitPrintDic.removeFirst()
        var isCheck = false // target보다 우선순위 높은 문서 여부
        
        for i in sortedWaitPrintDic {
            // 우선순위 더 높은 문서가 있다면 후순위로 넣기
            if i.value > target.value {
                sortedWaitPrintDic.append(target)
                isCheck = true
                break
            }
        }
        
        if !isCheck {
            endPrintDic.append(target)
        }
        
    }
    
    for i in endPrintDic {
        if i.key == location {
            break
        }
        answer += 1
    }
    
    return answer
}
