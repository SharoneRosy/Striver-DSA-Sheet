class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer>seen=new HashMap<>();
        List<Integer>res=new ArrayList<>();
        for(int i:nums1) seen.put(i,1);
        for(int x:nums2){
            if(seen.containsKey(x) && seen.get(x)==1){
                res.add(x);
                seen.put(x,0);
            }
        }
         return res.stream().mapToInt(i->i).toArray();
    }
}