import java.util.*;
class L_Permutation {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited =  new boolean[nums.length];
        dfs(nums, new ArrayList<>(), visited);
        return result;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] visited){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i <= nums.length-1; i++){

            if(visited[i]) continue;

            visited[i]=true;
            path.add(nums[i]);
            dfs(nums, path, visited);

            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}