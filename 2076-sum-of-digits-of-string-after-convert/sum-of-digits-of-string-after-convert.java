class Solution {
    public int getLucky(String s, int k) {
        String numstring="";
        for(char ch:s.toCharArray()){
            numstring+=Integer.toString(ch-'a'+1);
        }

        while(k-->0){
            int digitsum=0;
            for(char i:numstring.toCharArray()){
                digitsum+=i-'0';
            }
            if(digitsum<10) return digitsum;
            numstring=Integer.toString(digitsum);
        }
        return Integer.parseInt(numstring);
    }
}