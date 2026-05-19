class Solution(object):
    def isBipartite(self, graph):
        a = len(graph)
        ch = [0]*a
        def DFS(l, c):
            ch[l] = c

            for i in graph[l]:
                if ch[i] == c:
                    return False
                if ch[i] == 0:
                    if not DFS(i, -c):
                        return False
            return True

        for i in range(a):
            if ch[i] == 0:
                if not DFS(i, 1):
                    return False
        return True
        
