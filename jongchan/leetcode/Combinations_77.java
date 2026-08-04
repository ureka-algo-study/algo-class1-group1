import java.util.*;

//Combinations_77
public class Combinations_77 {
    static int[] input;
    static int[] bucket;

    static List<List<Integer>> results;
    static boolean[] isSelected;

    public static void main(String[] args) {
        combine(4, 2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        results = new ArrayList<>();
        input = new int[n];
        bucket = new int[k];

        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }

        isSelected = new boolean[n];

        backtracking(k, 0, 0);

        for (List<Integer> list : results) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        return results;
    }

    private static void backtracking(int k, int idx, int start) {
        if (idx >= k) {
            List<Integer> subs = new ArrayList<>();
            for (int value : bucket) {
                subs.add(value);
            }
            results.add(subs);
            return;
        }

        for (int i = start; i < input.length; i++) {
            bucket[idx] = input[i];
            backtracking(k, idx + 1, i + 1);
        }
    }
}