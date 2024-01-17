class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a[]=new int[2];
        a[0]=-1;
        a[1]=-1;
        int more;
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=nums[i];
            more=target-num;
            if(map.containsKey(more)){
                a[1]=map.get(more);
                a[0]=i;
                return a;
            }
            map.put(num,i);
            
        }return a;
    }
}