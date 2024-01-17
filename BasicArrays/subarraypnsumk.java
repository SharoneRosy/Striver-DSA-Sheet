package BasicArrays;

public class subarraypnsumk {
    public static int getLongestSubarray(int []nums, int k) {
		// Write your code here.
		int sum=0;
		int maxlen=0;
		HashMap<Integer,Integer>map=new HashMap<>();
		int n=nums.length;
		for(int i=0;i<n;i++){
			sum+=nums[i];
			if(sum==k){
				maxlen=Math.max(maxlen, i+1);
			}
			int rem=sum-k;
			if(map.containsKey(rem)){
				int len=i-map.get(rem);
				maxlen=Math.max(maxlen, len);
			}

			if(!map.containsKey(sum)){
				map.put(sum, i);
			}
		}
		return maxlen;
		
	}
}
