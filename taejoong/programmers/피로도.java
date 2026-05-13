class Solution {
    static boolean[] checked; // 던전 방문 체크
    static int result = 0; // 최대 던전 수
    
    public int solution(int k, int[][] dungeons) {
        checked = new boolean[dungeons.length];
        dfs(k, dungeons, 0);      
        return result;
    }
    
    private void dfs(int k, int[][] dungeons, int count) {
        // 탐험한 던전 수 최댓값 갱신
        result = Math.max(result, count);
        
        // 모든 던전 순회
        for(int i = 0; i < dungeons.length; i++) {
            // 이미 방문한 던전 건너뛰기
         if(checked[i]) continue;
            
            //최소 필요 피로도 확인
            if(k >= dungeons[i][0]) {
                
                //방문 처리
                checked[i] = true;
                
                //피로도 소모 후 다음 던전 호출
                dfs(k - dungeons[i][1], dungeons, count + 1);
                
                //백트래킹
                checked[i] = false;
            }
        }
    }
}