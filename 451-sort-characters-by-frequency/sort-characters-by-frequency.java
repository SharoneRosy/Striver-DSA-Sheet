class Solution {
    public String frequencySort(String S) {
        StringBuilder s=new StringBuilder();
        HashMap<Character,Integer>hm=new HashMap();

        for(char ch:S.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        List<Character>list=new ArrayList(hm.keySet());
        list.sort((ob1,ob2)->(hm.get(ob2)-hm.get(ob1)));
        for(char ch:list){
            for(int i=0;i<hm.get(ch);i++){
                s.append(ch);
            }
        }
        return s.toString();
    }
}