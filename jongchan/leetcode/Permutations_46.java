import java.io.*;
import java.util.*;

class Solution {
    static List<Integer> subs;
    static List<List<Integer>> result;
    static boolean[] isSelected;

    public List<List<Integer>> permute(int[] nums) {
        subs = new ArrayList<>();
        isSelected = new boolean[nums.length];

        permutations(nums, 0);
    }

    public void permutations(int[] nums, int idx) {
        if (idx >= nums.length) {
            List<Integer> s = new ArrayList<>();
            for (int num : subs) {
                s.add(num);
            }
            result.add(s);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isSelected[i]) {
                continue;
            }
            subs.add(nums[i]);
            isSelected[i] = true;
            permutations(nums, idx + 1);
            isSelected[i] = false;
            subs.remove(subs.size() - 1);
        }
    }
}