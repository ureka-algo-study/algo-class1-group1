package seoa.LeetCode;

import java.util.PriorityQueue;

public class LeetCode_767_ReorganizeString {
	public String reorganizeString(String s) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		
		int maxLimit = (s.length() + 1) / 2;
		for (int c : count) {
			if (c > maxLimit) return "";
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
		for (int i = 0; i < 26; i++) {
			if (count[i] > 0) {
				pq.offer(new int[]{i, count[i]});
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (pq.size() >= 2) {
			int[] first = pq.poll();
			int[] second = pq.poll();
			
			sb.append((char) (first[0] + 'a'));
			sb.append((char) (second[0] + 'a'));

			first[1]--;
			second[1]--;

			if (first[1] > 0) pq.offer(first);
			if (second[1] > 0) pq.offer(second);
		}

		if (!pq.isEmpty()) {
			int[] last = pq.poll();
			sb.append((char) (last[0] + 'a'));
		}
		
		return sb.toString();
	}
}
