class Solution {
    public long maxKelements(int[] nums, int k) {
	Map<Integer, Integer> map = new HashMap<>();
	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	for(int num : nums) {
		if(!map.containsKey(num)) {
			map.put(num, 1);
			pq.add(num);
		}
		else map.put(num, map.get(num) + 1);
	}

	long res = 0l;
	while(!pq.isEmpty() && k > 0) {
		int top = pq.remove();
		int ct = Math.min(map.get(top), k);
		res += (1l*top*ct);
		k -= ct;

		top = (int)Math.ceil((top*1d)/3);
		if(!map.containsKey(top)) {
			pq.add(top);
			map.put(top, ct);
		}
		else map.put(top, map.get(top) + ct);
	}

	return res+k;
}
}