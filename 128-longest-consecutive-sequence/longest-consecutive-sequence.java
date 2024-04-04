class Solution {
    public int longestConsecutive(int[] a) {
            Set <Integer>set = new HashSet<>();
  for(int e:a){
      set.add(e);
  }
  int ans=0;
  for(int e:set){
      if(!set.contains(e-1))
      {
          int len=1;
          while(set.contains(++e))
              len++;
          ans=Math.max(ans,len);
      }

  }
  return ans;
    }
}