# for i in range(n):
#     res = nums[i]
#     if res == k:
#         cnt += 1
#     for j in range(i+1, n):
#         res += nums[j]
#         if res == k:
#             cnt += 1

class Solution(object):
    def subarraySum(self, nums, k):
        result = 0
        prefix_sum = 0 
        d = {0: 1} 
        for i in nums:
            prefix_sum = prefix_sum + i


            if prefix_sum - k in d:
                result = result + d[prefix_sum - k]

          
            if prefix_sum not in d:
                d[prefix_sum] = 1
            else:
                d[prefix_sum] = d[prefix_sum] + 1

        return result
