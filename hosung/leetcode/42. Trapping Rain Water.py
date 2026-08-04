class Solution(object):
    def trap(self, height):

        stack = []
        water = 0

        for i in range(len(height)):

            # 현재 벽이 더 크면 물 계산 가능
            while stack and height[i] > height[stack[-1]]:

                # 바닥
                bottom = stack.pop()

                # 왼쪽 벽 없으면 종료
                if not stack:
                    break

                # 왼쪽 벽
                left = stack[-1]

                # 가로 길이
                width = i - left - 1

                # 물 높이
                h = min(height[left], height[i]) - height[bottom]

                # 물 양 추가
                water += width * h

            # 현재 인덱스 저장
            stack.append(i)

        return water
