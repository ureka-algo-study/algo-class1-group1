class Solution(object):
    def twoSum(self, nums, target):
        a = []
        n = len(nums)
        for i in range(n):
            for j in range(i+1,n):
                if nums[i]+nums[j] == target:
                    a.append(i)
                    a.append(j)
                    return a
