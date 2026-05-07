class Solution(object):
    def permute(self, nums):
        a = []
        res = []
        n = len(nums)
        ch = [0] * n
        def DFS(l):
            if l == n:
                res.append(a[:])
                return
            else:
                for i in range(n):
                    if ch[i] == 0:
                        ch[i] = 1
                        a.append(nums[i])
                        DFS(l+1)    
                        a.pop()
                        ch[i] = 0
        DFS(0)
        return res
