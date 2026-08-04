package seoa.pgs;

public class Lv2_피로도 {
    private int maxDungeons = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] isVisited = new boolean[dungeons.length];
        dfs(k, 0, dungeons, isVisited);
        return maxDungeons;
    }

    private void dfs(int fatigue, int count, int[][] dungeons, boolean[] isVisited) {
        // 방문한 던전 개수와 최대값을 비교하여 갱신
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            // 아직 방문하지 않았고, 피로도를 만족하는 경우
            if (!isVisited[i] && fatigue >= dungeons[i][0]) {
                isVisited[i] = true;
                // 현재 피로도에서 소모 피로도만큼 차감 후 재귀 호출
                dfs(fatigue - dungeons[i][1], count + 1, dungeons, isVisited);
                isVisited[i] = false;
	        }
	    }
	}
}
