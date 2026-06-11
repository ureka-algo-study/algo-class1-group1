import heapq

def solution(N, road, K):
    answer = 0
    graph = [[] for _ in range(N+1)]
    
    for a,b,c in road:
        graph[a].append((b,c))
        graph[b].append((a,c))
        
    dist = [float('inf')]* (N+1)
    dist[1] = 0
    pq = [(0,1)]
    while pq:
        curdist, node = heapq.heappop(pq)
        if curdist > dist[node]:
            continue
        for nxt, cost in graph[node]:
            new_dist = curdist + cost
            if new_dist < dist[nxt]:
                dist[nxt] = new_dist
                heapq.heappush(pq, (new_dist, nxt))
    return sum(1 for d in dist if d<=K)
