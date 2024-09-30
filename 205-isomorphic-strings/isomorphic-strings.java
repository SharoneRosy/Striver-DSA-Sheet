class Solution {
    public boolean isIsomorphic(String s, String t) {
        int [] stot=new int[256];
        Arrays.fill(stot,-1);
        int [] ttos=new int[256];
        Arrays.fill(ttos,-1);
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(stot[c1]==-1 && ttos[c2]==-1){
                stot[c1]=c2;
                ttos[c2]=c1;
            }
            else if(!(stot[c1]==c2 && ttos[c2]==c1)){
                return false;
            }
        }
        return true;
    }
}