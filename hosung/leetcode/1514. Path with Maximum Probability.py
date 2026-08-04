import heapq

class Solution(object):
    def maxProbability(self, n, edges, succProb, start_node, end_node):

        graph = [[] for _ in range(n)]

        for i in range(len(edges)):
            u, v = edges[i]
            graph[u].append((v, succProb[i]))
            graph[v].append((u, succProb[i]))

        probs = [0] * n
        probs[start_node] = 1

        pq = [(-1, start_node)]

        while pq:

            cur_prob, node = heapq.heappop(pq)
            cur_prob = -cur_prob

            if node == end_node:
                return cur_prob

            if cur_prob < probs[node]:
                continue

            for nxt, p in graph[node]:

                new_prob = cur_prob * p

                if new_prob > probs[nxt]:
                    probs[nxt] = new_prob
                    heapq.heappush(pq, (-new_prob, nxt))

        return 0
