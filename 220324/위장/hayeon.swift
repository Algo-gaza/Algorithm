import Foundation


func solution(_ clothes:[[String]]) -> Int {
    
    // 각 행의 1번째 열을 기준으로 정렬하여 "의상의 종류"대로 나열한다.
    var sortedClothes = clothes.sorted{ $0[1] > $1[1] }
    
    // 초기화, 선언
    var currentType = sortedClothes[0][1]
    var cntArr: [Int] = []
    var cnt = 0
    
    // 의상의 종류에 따라 구분
    for targetClothes in sortedClothes {
        
        // 의상 종류가 같다면 이 의상종류의 경우의 수가 증가해야하므로 cnt를 더해준다.
        if targetClothes[1] == currentType {
            cnt += 1
        }else {
            // 의상 종류가 다르면 이전 의상종류의 경우의 수를 cntArr의 배열에 넣어준 뒤 초기화, 현재 의상종류를 교체
            cntArr.append(cnt)
            currentType = targetClothes[1]
            cnt = 1
        }
    }
    
    // 최종만 따로 cntArr에 넣어준다.
    cntArr.append(cnt)
    
    // 맨 위에 주석처리한 부분처럼 동작
    return cntArr.map{ $0+1 }.reduce(1,*) - 1
}
