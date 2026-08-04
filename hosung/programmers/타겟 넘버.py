def solution(numbers, target):
    answer = 0
    n = len(numbers)
    def DFS(l, t):
        nonlocal answer
        if l == n:
            if t == target:
                answer+=1
            return
        DFS(l+1, t + numbers[l])
        DFS(l+1, t - numbers[l])
            

        
    DFS(0, 0)
    return answer
