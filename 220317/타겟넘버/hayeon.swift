import Foundation

func solution(_ numbers:[Int], _ target:Int) -> Int {
    return dfs(numbers,target,0,0)
}

func dfs(_ numbers:[Int], _ target: Int, _ depth: Int, _ resultNum: Int) -> Int {
    if numbers.count == depth {
        return resultNum == target ? 1 : 0
    }
    return dfs(numbers,target,depth+1,resultNum+numbers[depth]) + dfs(numbers,target,depth+1,resultNum-numbers[depth])
}
