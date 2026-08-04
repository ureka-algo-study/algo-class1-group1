from collections import deque

class Solution:
    def findOrder(self, numCourses, prerequisites):

        graph = {}
        indegree = [0] * numCourses

        for course, pre in prerequisites:
            if pre not in graph:
                graph[pre] = []
            graph[pre].append(course)
            indegree[course] += 1

        queue = deque()

        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)

        order = []

        while queue:
            cur = queue.popleft()
            order.append(cur)

            if cur in graph:
                for nxt in graph[cur]:
                    indegree[nxt] -= 1
                    if indegree[nxt] == 0:
                        queue.append(nxt)

        return order if len(order) == numCourses else []
