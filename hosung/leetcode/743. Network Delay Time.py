import heapq

class Solution:
    def networkDelayTime(self, times, n, k):

        graph = [[] for _ in range(n + 1)]

        for u, v, w in times:
            graph[u].append((v, w))

        dist = [float('inf')] * (n + 1)
        dist[k] = 0

        pq = [(0, k)]

        while pq:

            cur_dist, node = heapq.heappop(pq)

            if cur_dist > dist[node]:
                continue

            for nxt, cost in graph[node]:

                new_dist = cur_dist + cost

                if new_dist < dist[nxt]:
                    dist[nxt] = new_dist
                    heapq.heappush(pq, (new_dist, nxt))

        answer = max(dist[1:])

        return answer if answer != float('inf') else -1
