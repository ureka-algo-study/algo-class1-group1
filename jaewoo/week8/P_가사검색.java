package algo-class1-group1.jaewoo.week8;

import java.util.HashMap;
import java.util.Map;

public class P_가사검색 {

    static class Trie {
        Trie[] children = new Trie[26];
        Map<Integer, Integer> lengthCount = new HashMap<>();

        void insert(String word) {
            Trie node = this;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int c = word.charAt(i) - 'a';
                if (node.children[c] == null) node.children[c] = new Trie();
                node = node.children[c];
                node.lengthCount.merge(len, 1, Integer::sum);
            }
        }

        int find(String query) {
            Trie node = this;
            int len = query.length();
            for (int i = 0; i < len; i++) {
                char ch = query.charAt(i);
                if (ch == '?') {
                    return node.lengthCount.getOrDefault(len, 0);
                }
                int c = ch - 'a';
                if (node.children[c] == null) return 0;
                node = node.children[c];
            }
            return node.lengthCount.getOrDefault(len, 0);
        }
    }

    public int[] solution(String[] words, String[] queries) {
        Trie forward = new Trie();
        Trie backward = new Trie();

        Map<Integer, Integer> totalByLength = new HashMap<>();

        for (String w : words) {
            forward.insert(w);
            backward.insert(new StringBuilder(w).reverse().toString());
            totalByLength.merge(w.length(), 1, Integer::sum);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (q.charAt(0) == '?' && q.charAt(q.length() - 1) == '?') {
                answer[i] = totalByLength.getOrDefault(q.length(), 0);
            } else if (q.charAt(0) == '?') {
                answer[i] = backward.find(new StringBuilder(q).reverse().toString());
            } else {
                answer[i] = forward.find(q);
            }
        }
        return answer;
    }
}
