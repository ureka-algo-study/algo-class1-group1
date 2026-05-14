class Solution(object):
    def canVisitAllRooms(self, rooms):
        st = [0]
        ch = [0]*len(rooms)

        while st:
            l = st.pop()
            ch[l] = 1

            for i in rooms[l]:
                if ch[i] ==0:
                    st.append(i)

        for i in ch:
            if i == 0:
                return False
        else:
            return True
                    
