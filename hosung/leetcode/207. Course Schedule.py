class Solution(object):
    def canFinish(self, numCourses, prerequisites):

        # 그래프 생성
        graph = [[] for _ in range(numCourses)]

        for course, pre in prerequisites:
            graph[pre].append(course)

        # 0: 미방문, 1: 탐색중, 2: 탐색완료
        state = [0] * numCourses

        def dfs(node):

            # 현재 탐색 경로에서 다시 만남 -> 사이클
            if state[node] == 1:
                return False    

            # 이미 검사 끝난 노드
            if state[node] == 2:
                return True

            state[node] = 1

            for nxt in graph[node]:
                if not dfs(nxt):
                    return False

            state[node] = 2
            return True

        for i in range(numCourses):
            if not dfs(i):
                return False

        return True
