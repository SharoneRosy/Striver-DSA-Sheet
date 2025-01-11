class Solution {
    // Time complexity: O(n)
// Space complexity: O(1)

public int maxProduct(int[] nums) {
	int maxProduct = Integer.MIN_VALUE;
	int max = 1;
	int min = 1;

	for (int num : nums) {
		int temp = max * num; // value of max will not be lost
		max = Math.max(num, Math.max(min * num, temp));
		min = Math.min(num, Math.min(min * num, temp));
		
		maxProduct = Math.max(maxProduct, max);
	}

	return maxProduct;
}

}