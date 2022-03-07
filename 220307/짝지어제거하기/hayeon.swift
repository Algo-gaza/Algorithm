import Foundation

func solution(_ s:String) -> Int{
    var answer:Int = -1
    var stack: [Character] = []
    
    for ch in s {
        if stack.count == 0 || stack.last! != ch {
            stack.append(ch)
        }else {
            stack.removeLast()
        }
    }
    
    return stack.count == 0 ? 1 : 0
}
