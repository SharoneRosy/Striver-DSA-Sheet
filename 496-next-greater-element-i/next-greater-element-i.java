class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        Stack<Integer>st=new Stack<>();
        for(int i:nums2){
            while(!st.isEmpty() && i>st.peek()){
                map.put(st.pop(),i);
            }
            st.push(i);
        }
        int res[]=new int[nums1.length];
        int j=0;
        for(int i:nums1){
            res[j++]=map.getOrDefault(i,-1);
        }
        return res;
    }
}