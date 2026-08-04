package seoa.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode_841_KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Queue<Integer> check = new ArrayDeque<>();
		boolean[] isVisited = new boolean[rooms.size()];
		
		isVisited[0] = true;
		check.offer(0);
		
		while (!check.isEmpty()) {
			int nowRoom = check.poll();
			for (int key : rooms.get(nowRoom)) {
				if (!isVisited[key]) {
					isVisited[key] = true;
					check.offer(key);
				}
			}
		}
		
		for (boolean visit : isVisited) {
			if (!visit) {
				return false;
			}
		}
		
		return true;
	}
}

/*

public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	boolean[] isVisited = new boolean[rooms.size()];

	dfs(0, rooms, isVisited);

	for (boolean visited : isVisited) {
		if (!visited) {
		return false;
		}
	return true;
	}
}

private void dfs(int nowRoom, List<List<Integer>> rooms, boolean[] isVisited) {
	//
	isVisited[nowRoom] = true;

	for (int key : rooms.get(nowRoom)) {
		if (!isVisited[key]) {
			dfs(key, rooms, isVisited);
		}
	}
}
 
 */