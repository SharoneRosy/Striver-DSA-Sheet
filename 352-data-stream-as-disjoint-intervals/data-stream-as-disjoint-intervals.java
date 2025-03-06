
class SummaryRanges {
    private TreeMap<Integer, Integer> map; // Stores {start -> end} of each interval

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {
        if (map.containsKey(value)) return; // Ignore duplicate values

        Integer lowerKey = map.floorKey(value); // Largest key ≤ value
        Integer higherKey = map.ceilingKey(value); // Smallest key ≥ value

        // Case 1: Merge with lower and higher interval (value fills the gap)
        if (lowerKey != null && higherKey != null && map.get(lowerKey) + 1 == value && higherKey == value + 1) {
            map.put(lowerKey, map.get(higherKey)); // Merge both intervals
            map.remove(higherKey);
        } 
        // Case 2: Merge with lower interval
        else if (lowerKey != null && map.get(lowerKey) + 1 >= value) {
            map.put(lowerKey, Math.max(map.get(lowerKey), value));
        } 
        // Case 3: Merge with higher interval
        else if (higherKey != null && higherKey == value + 1) {
            map.put(value, map.get(higherKey)); // Extend interval backward
            map.remove(higherKey);
        } 
        // Case 4: Standalone new interval
        else {
            map.put(value, value);
        }
    }

    public int[][] getIntervals() {
        int[][] result = new int[map.size()][2];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }
        return result;
    }
}