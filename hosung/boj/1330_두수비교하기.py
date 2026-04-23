import sys
#sys.stdin=open("input.txt", "r")

n, m = map(int, input().split())
a = list(map(int, input().split()))

def count(mid):
    cnt = 1
    ok = 0
    for i in a:
        if ok+i > mid:
            cnt+=1
            ok = i
        else:
            ok += i
    return cnt
 

lt = 1
rt = sum(a)
res = 0
while lt <= rt:
    mid = (lt+rt)//2
    if count(mid) <= m:
        res = mid
        rt = mid-1
    else:
        lt = mid+1
print(res)