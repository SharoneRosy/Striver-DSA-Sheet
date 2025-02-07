class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; // Each node has 2 children (0 and 1)
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        // Step 1: Insert all numbers into the Trie
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) { // 32-bit representation
                int bit = (num >> i) & 1; // Extract i-th bit
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        int max_xor = 0;

        // Step 2: Find the maximum XOR for each number
        for (int num : nums) {
            TrieNode node = root;
            int curr_xor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int opposite = 1 - bit; // Try to get the opposite bit for maximum XOR
                
                if (node.children[opposite] != null) {
                    curr_xor |= (1 << i); // Set the i-th bit in XOR result
                    node = node.children[opposite]; // Move to opposite bit
                } else {
                    node = node.children[bit]; // Move to the same bit
                }
            }
            max_xor = Math.max(max_xor, curr_xor);
        }

        return max_xor;
    }
}
