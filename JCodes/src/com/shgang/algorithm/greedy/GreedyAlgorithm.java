package com.shgang.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
	public static void main(String[] args) {
		HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
		HashSet<String> radioset1 = new HashSet<>();
		radioset1.add("北京");
		radioset1.add("上海");
		radioset1.add("天津");
		HashSet<String> radioset2 = new HashSet<>();
		radioset2.add("广州");
		radioset2.add("北京");
		radioset2.add("深圳");
		HashSet<String> radioset3 = new HashSet<>();
		radioset3.add("成都");
		radioset3.add("上海");
		radioset3.add("杭州");
		HashSet<String> radioset4 = new HashSet<>();
		radioset4.add("上海");
		radioset4.add("天津");
		HashSet<String> radioset5 = new HashSet<>();
		radioset5.add("杭州");
		radioset5.add("大连");

		broadcasts.put("K1", radioset1);
		broadcasts.put("K2", radioset2);
		broadcasts.put("K3", radioset3);
		broadcasts.put("K4", radioset4);
		broadcasts.put("K5", radioset5);

		HashSet<String> allAreas = new HashSet<>();
		for (String key : broadcasts.keySet()) {
			HashSet<String> areas = broadcasts.get(key);
			for (String area : areas) {
				if (!allAreas.contains(area)) {
					allAreas.add(area);
				}
			}
		}


		ArrayList<String> selects = new ArrayList<>();
		HashSet<String> tempSet = new HashSet<>();
		String maxKey;
		while (allAreas.size() != 0) {
			maxKey = null;
			for (String key : broadcasts.keySet()) {
				tempSet.clear();
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				tempSet.retainAll(allAreas);
				if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
					maxKey = key;
				}
			}
			if (maxKey != null) {
				selects.add(maxKey);
				allAreas.removeAll(broadcasts.get(maxKey));
			}
		}
		System.out.println(selects);

	}

}
