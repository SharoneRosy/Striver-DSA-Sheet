class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map=new TreeMap<>();
        for(int i=0;i<names.length;i++){
            map.put(heights[i],names[i]);
        }
        int j=names.length-1;
        for(int i:map.keySet()){
            names[j--]=map.get(i);
        }
        return names;
    }
}