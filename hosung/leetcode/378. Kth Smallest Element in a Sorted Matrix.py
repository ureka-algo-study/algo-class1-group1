class Solution(object):
    def kthSmallest(self, matrix, k):
        a = []
        b = len(matrix)
        c = len(matrix[0])
        for i in range(b):
            for j in range(c):
                a.append(matrix[i][j])
        a.sort()
        return a[k-1]