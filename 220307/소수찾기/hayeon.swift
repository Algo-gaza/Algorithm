import Foundation

func solution(_ numbers:String) -> Int {
    let numbers = numbers
    let numbersArr = numbers.map{ String($0) }
    var res: Set<Int> = []
    
    for num in 1...numbersArr.count {
        getPermutation(numbersArr,num,&res,0)
    }
    
    return res.count
}

func getPermutation(_ arr: [String], _ targetNum: Int, _ result: inout Set<Int>, _ idx: Int = 0) {
    var arr = arr
    
    if idx == targetNum {
        let stringArr = Array(arr[0..<idx])
        let joinArr = stringArr.joined(separator: "")
        let addNum = Int(joinArr)!
        if isPrime(addNum) {
            result.insert(addNum)
        }
        
    }
    
    for i in idx..<arr.count {
        arr.swapAt(idx,i)
        getPermutation(arr,targetNum,&result,idx+1)
        arr.swapAt(idx,i)
    }   
}

func isPrime(_ num: Int) -> Bool {
    if num < 2 {
        return false
    }
    
    for i in 2..<num {
        if num%i == 0 {
            return false
        }
    }
    return true
}
