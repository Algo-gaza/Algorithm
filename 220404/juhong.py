def solution(s):
    answer = ''
    s1 = s.lower().split(' ')
    for i in s1:
        i = i.capitalize()
        if answer == '':
            answer = i
        else :
            answer = answer + ' ' + i
    return answer
