class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < nums2.length;i ++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                al.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        int ans[] = new int[al.size()];
        for(int i = 0 ; i < al.size(); i ++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}