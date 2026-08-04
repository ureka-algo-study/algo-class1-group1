def solution(orders, course):
    answer = []

    def DFS(cou, start, order,path):
        if len(path) == cou:
            path = "".join(path)
            if path in dic:
                dic[path] +=1
            else:
                dic[path] = 1
            return
        else:
            for i in range(start, len(order)):
                path.append(order[i])
                DFS(cou, i+1, order, path)
                path.pop()
                
                
        
    
    for i in course:
        dic = {}
        for order in orders:
            path=[]
            order = sorted(order)
            DFS(i,0,order,path)
        max1 = 0
        for i in dic.values():
            if i >=2:
                max1 = max(max1, i)
        for k, v in dic.items():
            if v == max1 and v>=2:
                answer.append(k)


    return sorted(answer)