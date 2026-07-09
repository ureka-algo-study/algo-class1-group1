
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int hold = -prices[0]; //보유
        int sold = 0;          //매도
        int rest = 0;          

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold, prevSold = sold, prevRest = rest;

            sold = prevHold + prices[i];                       // 들고 있던 걸 오늘 팜
            hold = Math.max(prevHold, prevRest - prices[i]);   // 계속 보유 or 오늘 새로 삼
            rest = Math.max(prevRest, prevSold);               // 계속 쉼 or 쿨다운 끝남
        }

        // 마지막 날은 주식이 없어야 함
        return Math.max(sold, rest);
    }
}
