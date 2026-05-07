class Solution(object):
    def combine(self, n, k):
        a = []
        res = []

        def DFS(l):
            if len(a) == k:
                res.append(a[:])

            else:
                for i in range(l, n+1):
                    a.append(i)
                    DFS(i+1)  
                    a.pop()      
        DFS(1)
        return res