class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return b - a;
            }
            return map.get(a) - map.get(b);
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
        }

        int[] result = new int[n];
        int i = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();

            int val = map.get(num);
            while (val != 0) {
                result[i++] = num;
                val--;
            }
        }
        return result;
    }
}