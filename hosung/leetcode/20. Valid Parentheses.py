class Solution(object):
    def isValid(self, s):
        a = {')':'(', ']':'[', '}':'{'}
        st = []
        for i in s:
            if i in '([{':
                st.append(i)
            else:
                if st and a[i] == st[-1] :
                    st.pop()
                else:
                    return False
        return len(st) ==0
