class Solution {
    static class TrieNode{
        TrieNode[] children=new TrieNode[2];
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root=new TrieNode();

        for(int num:nums){
            TrieNode node=root;
            for(int i=31;i>=0;i--){
                int bit=(num>>i)& 1;
                if(node.children[bit]==null){
                    node.children[bit]=new TrieNode();
                }
                node=node.children[bit];
            }
        }

        int max_xor=0;
        for(int num:nums){
            TrieNode node=root;
            int curr_xor=0;
            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                int opp=1-bit;
                if(node.children[opp]!=null){
                    curr_xor |= (1<<i);
                    node=node.children[opp];
                }else{
                    node=node.children[bit];
                }
            }
            max_xor=Math.max(max_xor,curr_xor);
        }
        return max_xor;
    }
}