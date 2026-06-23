def solution(s):

    answer = 2147000000
    for j in range(1, len(s)+1):
        res = ""
        cnt = 1
        ep = s[:j]

        for i in range(j,len(s),j):
            if s[i:i+j] == ep:
                cnt+=1
            else:
                if cnt>1:
                    res += str(cnt) + ep
                else:
                    res+=ep
                cnt = 1
                ep = s[i:i+j]
        if cnt >1:
            res += str(cnt) +ep
        else:
            res+=ep
        if len(res) < answer:
            answer = len(res)


    return answer
            
        
                
                
                
