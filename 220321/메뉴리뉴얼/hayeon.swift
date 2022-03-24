import Foundation

func solution(_ orders:[String], _ course:[Int]) -> [String] {
    
    var answerSet = Set<String>()
    
    for cnt in course {
        var res: [String] = []
        var maxCnt: Int = 2
        for order in orders {
            let orderArr: [String] = order.map{ String($0) }
            collection(orderArr,cnt,&res,0,[])
        }
        
        for (idx,element) in res.enumerated() {
            let elementCnt = res.filter { ($0) == element }.count
            if elementCnt > maxCnt {
                maxCnt = elementCnt
            }
        }
        
        for (idx,element) in res.enumerated() {
            let elementCnt = res.filter { ($0) == element }.count
            if elementCnt == maxCnt {
                answerSet.insert(element)
            }
        }
    }
    return answerSet.sorted{ $0 < $1 }
}

func collection(_ arr: [String], _ targetNum: Int, _ res: inout [String], _ idx: Int = 0, _ tmp: [String]) {
    if tmp.count == targetNum {
        let sortedTmp = tmp.sorted(by: <)
        res.append(sortedTmp.joined())
        return
    }
    
    for i in idx..<arr.count {
        collection(arr,targetNum,&res,i+1,tmp+[arr[i]])
    }
    
}
