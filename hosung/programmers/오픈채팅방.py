def solution(record):
    n = {}
    answer = []

    for i in record:
        parts = i.split()
        a = parts[0]  
        b = parts[1]  
        
        if a == "Enter" or a == "Change":
            c = parts[2]  
            n[b] = c


            
    for i in record:
        parts = i.split()
        a = parts[0]  
        b = parts[1]    

        if a == "Enter": 
            answer.append(n[b]+"님이 들어왔습니다.")
            
        elif a == "Leave":
            answer.append(n[b]+"님이 나갔습니다.")
    return answer
