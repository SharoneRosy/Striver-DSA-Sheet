class Solution {
    public int compress(char[] chars) {
        int i=0,res=0;
        while(i<chars.length){
            int grouplen=1;
            while(i+grouplen <chars.length && chars[i+grouplen]==chars[i]){
                grouplen++;
            }
            chars[res++]=chars[i];
            if(grouplen>1){
                for(char c :Integer.toString(grouplen).toCharArray()){
                    chars[res++]=c;
                }
            }
            i+=grouplen;
        }
        return res;
    }
}