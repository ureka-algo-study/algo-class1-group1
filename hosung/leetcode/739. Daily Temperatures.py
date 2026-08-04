class Solution(object):
    def dailyTemperatures(self, temperatures):
        n =len(temperatures)
        st = []
        res = [0]*len(temperatures)
        for i in range(n):
            while st and temperatures[i] > temperatures[st[-1]]:
                idx = st.pop()
                res[idx] = i -idx

            st.append(i)
            
        return res
                
                

        
