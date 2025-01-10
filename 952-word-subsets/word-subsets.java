class Solution {

    static void settingmaxfreq2(int[] maxfreq2,int[] freq2){
        for(int i=0;i<26;i++){
            maxfreq2[i]=Math.max(maxfreq2[i],freq2[i]);
        }
    }
    static boolean isuniversal(int[] maxfreq2,int[] freq1){
        for(int i=0;i<26;i++){
            if(freq1[i]<maxfreq2[i]){
                return false;
            }
        }
        return true;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res=new ArrayList<>();
        int[] maxfreq2=new int[26];
      
        // finding maxfrequency of the alphabets in words2
        for(String str:words2){
            int[] freq2=new int[26];
            for(char ch:str.toCharArray()){
                freq2[ch-'a']++;
            }
            settingmaxfreq2(maxfreq2,freq2);
        }
        // finding if the word is universal from the words2 array.

        for(String str:words1){
            int[] freq1=new int[26];
            for(char ch:str.toCharArray()){
                freq1[ch-'a']++;
            }
           if( isuniversal(maxfreq2,freq1)){
                res.add(str);
            }
        } 
        return res;
    }
}