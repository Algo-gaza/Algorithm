def solution(n):
    answer = 0
    tmp = 0
    for i in range(1, n + 1):
        for j in range(i, n + 1):
            tmp += j
            if tmp == n:
                answer += 1
                tmp = 0
                break
            elif tmp > n:
                tmp = 0
                break
    return answer