import java.util.*;
class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
    
        dfs (1, n, k);
        return answer;
    }
    public void dfs(int start, int n, int k){
        if(path.size() == k){
            answer.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n; i++ ){
            path.add(i);
            dfs(i+1, n, k);
            path.remove(path.size()-1);
        }
    }
}