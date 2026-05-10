class P_87946 {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] check = new boolean[dungeons.length]; // 방문 확인용
        int count = 0;                                  // 던전 방문 count
        dfs (count, k, dungeons, check);
        return max;                                     // 정답 리턴
    }//class
        public void dfs(int count, int k, int dungeons[][], boolean check[]){
            if (max < count) max = count;               // max값 갱신
            
            for (int i = 0; i < dungeons.length; i++){
            if (check[i]) continue;                     // 방문했으면 skip
            if (k >= dungeons[i][0]) {                  // 던전 방문가능 조건
                k -= dungeons[i][1];                    // 현재 피로도 계산
                check[i] = true;                        // 방문 check
                
                dfs(count+1, k, dungeons, check);
                
                check[i] = false;                       // 방문 복구
                k += dungeons[i][1];                    // 피로도 복구
                }//if
            }//fori
        }//dfs
}//sol