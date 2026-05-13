def solution(k, dungeons):
    answer = -1
    ch = [0]*len(dungeons)
    def DFS(l,cnt):
        nonlocal answer
        answer = max(answer, cnt)
        for i in range(len(dungeons)):
            if l >= dungeons[i][0] and ch[i] == 0:
                ch[i] = 1
                DFS(l-dungeons[i][1],cnt+1)
                ch[i] = 0
                
    DFS(k,0)
    
    return answer
