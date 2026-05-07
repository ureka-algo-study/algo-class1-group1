import java.util.*;
 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>(); 
        int[] arr = new int[2];
        map.put(nums[0],0);

        for(int i=1;i<nums.length;i++){
            int diff = target-nums[i];
            if(map.get(diff) != null){
                arr[0] = map.get(diff);
                arr[1] = i;
                break;
            }
            map.put(nums[i],i);
        }

        return arr;
    }
}   