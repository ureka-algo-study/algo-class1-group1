import sys
sys.setrecursionlimit(10**6)

def solution(a, edges):
    n = len(a)

    if sum(a) != 0:
        return -1

    graph = [[] for _ in range(n)]
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    answer = 0

    def dfs(node, parent):
        nonlocal answer

        total = a[node]

        for nxt in graph[node]:
            if nxt == parent:
                continue
            total += dfs(nxt, node)

        answer += abs(total)
        return total

    dfs(0, -1)
    return answer
